package com.wwy.android.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

/**
 *@创建者wwy
 *@创建时间 2019/10/9 11:10
 *@描述
 */
abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (callBack()) {
            requireActivity().onBackPressedDispatcher.addCallback(
                this,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        popBackStack()
                    }
                })
        }
    }

    open fun callBack(): Boolean = true
    open fun popBackStack() {
        findNavController().popBackStack()
    }

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

    protected open fun onFragmentFirstVisible() {
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