package com.leshu.superbrain.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *@创建者wwy
 *@创建时间 2019/10/9 11:10
 *@描述
 */
abstract class BaseFragment : Fragment() {
    private var isLoaded = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(setLayoutResId(), container, false)
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            onFragmentFirstVisible()
            isLoaded = true
        }
    }

    protected open fun onFragmentFirstVisible(){
        initView()
        initData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun setLayoutResId(): Int

    abstract fun initView()

    abstract fun initData()
}