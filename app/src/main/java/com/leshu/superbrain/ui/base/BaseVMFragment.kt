package com.leshu.superbrain.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leshu.superbrain.repository.base.BaseRepository
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException
import timber.log.Timber
import java.lang.Exception


/**
 *@创建者wwy
 *@创建时间 2019/9/17 14:53
 *@描述
 */
abstract class BaseVMFragment<VM : BaseViewModel> : Fragment() {
    protected lateinit var mViewModel: VM
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(setLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initVM()
        initView()
        initData()
        startObserve()
        super.onViewCreated(view, savedInstanceState)
    }

    open fun providerVMClass(): Class<VM>? = null
    private fun initVM() {
        providerVMClass()?.let {
            mViewModel = ViewModelProviders.of(this).get(it)
            lifecycle.addObserver(mViewModel)
        }
    }

    abstract fun setLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()
    open fun startObserve() {
        mViewModel.run {
            getError().observe(this@BaseVMFragment, Observer {
                requestError(it)
            })
            getStart().observe(this@BaseVMFragment, Observer {
                requestStart(it)
            })
            getFinally().observe(this@BaseVMFragment, Observer {
                requestFinally(it)
            })
        }
    }

    /**
     * 请求完成 可以做完成之后的操作
     * @param it 是否需要进度条
     */
    open fun requestFinally(it: Boolean?) {
        it?.run {
            when (it) {
                true -> Timber.tag("wangwuyuan").d("需要->结束")
                false -> Timber.tag("wangwuyuan").d("不需要")
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
                true -> Timber.tag("wangwuyuan").d("需要->开始")
                false -> Timber.tag("wangwuyuan").d("不需要")
            }
        }
    }

    /**
     * 常见异常处理
     */
    private fun requestError(it: Exception?) {
        it?.run {
            when (it) {
                is HttpException -> {
                }   //网络异常
                is TimeoutCancellationException -> {
                }  //请求超时
                is BaseRepository.LogonFailureException -> {

                }//登录已失效
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