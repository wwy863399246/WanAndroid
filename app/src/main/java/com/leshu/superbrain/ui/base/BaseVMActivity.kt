package com.leshu.superbrain.ui.base

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leshu.superbrain.vm.base.BaseViewModel
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException
import timber.log.Timber
import java.lang.Exception

/**
 *@创建者wwy
 *@创建时间 2019/9/10 17:51
 *@描述 abstract 抽象类或者方法默认是带着的open
 * open关键字 与java 中的 final相反:它允许别的类继承这个类。默认情形下，kotlin 中所有的类都是 final ,用来表示他可以被继承。
 * 若子类要重写父类中的方法，则需在父类的方法前面加open关键字，然后在子类重写的方法前加override关键字
 * lateinit var延迟初始化 只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)
 * by lazy要求属性声明为val，即不可变变量，在java中相当于被final修饰。这意味着该变量一旦初始化后就不允许再被修改值了(基本类型是值不能被修改，对象类型是引用不能被修改)。{}内的操作就是返回唯一一次初始化的结果。
 * by lazy可以使用于类属性或者局部变量。
 */
abstract class BaseVMActivity<VM : BaseViewModel> : BaseActivity() {
    lateinit var mViewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        initVM()
        super.onCreate(savedInstanceState)
        startObserve()
    }

    /**
     * [BaseViewModel]的实现类
     */
    open fun providerVMClass(): Class<VM>? = null

    /**
     *  如果要只对非空值执行某个操作，安全调用操作符可以与 let 一起使用：
     */
    private fun initVM() {
        providerVMClass()?.let { it ->
            mViewModel = ViewModelProviders.of(this).get(it)
            mViewModel.let { lifecycle::addObserver }
        }
    }

    open fun startObserve() {
        mViewModel.run {
            getError().observe(this@BaseVMActivity, Observer {
                requestError(it)
            })
            getStart().observe(this@BaseVMActivity, Observer {
                requestStart(it)
            })
            getFinally().observe(this@BaseVMActivity, Observer {
                requestFinally(it)
            })
        }

    }

    /**
     * 请求完成 可以做完成之后的操作
     * @param it 是否需要进度条
     */
    private fun requestFinally(it: Boolean?) {
        it?.run {
            when (it) {
                true -> Timber.tag("wwywwy").d("需要")
                false -> Timber.tag("wwywwy").d("不需要")
            }
        }
    }

    /**
     * 请求开始 请求完成 可以做开始准备的操作
     * @param it 是否需要进度条
     */
    open fun requestStart(it: Boolean?) {
        it?.run {
            when (it) {
                true -> Timber.tag("wwywwy").d("需要")
                false -> Timber.tag("wwywwy").d("不需要")
            }
        }
    }

    /**
     * 常见异常处理
     */
    open fun requestError(it: Exception?) {
        it?.run {
            when (it) {
                is HttpException -> {
                }   //网络异常
                is TimeoutCancellationException -> {
                }  //请求超时
            }

        }
    }

    override fun onDestroy() {
        mViewModel.let {
            lifecycle.removeObserver(it)
        }
        super.onDestroy()
    }

}