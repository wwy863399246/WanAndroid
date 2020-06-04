package com.leshu.superbrain.ui.base

import android.os.Bundle
import android.view.View
import com.leshu.superbrain.vm.base.BaseViewModel


/**
 *@创建者wwy
 *@创建时间 2019/9/17 14:53
 *@描述
 */
abstract class BaseVMFragment<VM : BaseViewModel> : BaseFragment() {
    protected lateinit var mViewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onFragmentFirstVisible() {
        mViewModel = initVM()
        startObserve()
        super.onFragmentFirstVisible()
    }


    abstract fun initVM(): VM

    open fun startObserve() {}

}