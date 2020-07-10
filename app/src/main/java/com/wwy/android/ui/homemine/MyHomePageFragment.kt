package com.wwy.android.ui.homemine

import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.wwy.android.R
import com.wwy.android.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_my_home_page.*
import org.jetbrains.anko.image
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 *@创建者wwy
 *@创建时间 2020/7/8 11:46
 *@描述
 */
class MyHomePageFragment : BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_my_home_page

    override fun initView() {
        tvMyIntegral.onClick {
            findNavController().navigate(R.id.action_myHomePageFragment_to_myIntegralFragment)
        }
    }

    override fun initData() {
    }
}