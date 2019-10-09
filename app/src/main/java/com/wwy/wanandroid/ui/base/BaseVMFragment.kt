package com.wwy.wanandroid.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


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

    open fun startObserve() {
        mViewModel.mException.observe(this, Observer { it?.let { onError(it) } })
    }

    private fun initVM() {
        providerVMClass()?.let {
            mViewModel = ViewModelProviders.of(this).get(it)
            lifecycle.addObserver(mViewModel)
        }
    }

    open fun providerVMClass(): Class<VM>? = null

    open fun onError(e: Throwable) {}
    abstract fun setLayoutResId(): Int
    abstract fun initView()
    abstract fun initData()


    override fun onDestroy() {
        mViewModel?.let {
            lifecycle.removeObserver(it)
        }
        super.onDestroy()
    }
}