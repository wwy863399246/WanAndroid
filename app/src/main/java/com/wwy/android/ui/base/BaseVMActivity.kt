package com.wwy.android.ui.base

import android.os.Bundle
import com.wwy.android.vm.base.BaseViewModel

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

    override fun initActivity(savedInstanceState: Bundle?) {
        mViewModel = initVM()
        startObserve()
        super.initActivity(savedInstanceState)
    }

    abstract fun initVM(): VM

    abstract fun startObserve()
}