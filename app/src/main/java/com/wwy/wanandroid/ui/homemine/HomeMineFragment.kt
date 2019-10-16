package com.wwy.wanandroid.ui.homemine

import com.wwy.wanandroid.ui.base.BaseVMFragment
import com.wwy.wanandroid.R
import com.wwy.wanandroid.ui.base.BaseFragment
import com.wwy.wanandroid.util.GlideImageLoader
import kotlinx.android.synthetic.main.fragment_home_mine.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomeMineFragment : BaseFragment() {
    override fun setLayoutResId(): Int = R.layout.fragment_home_mine

    override fun initData() {
    }

    override fun initView() {
        activity?.let { GlideImageLoader().displayCircleImage(it,R.drawable.wwy,iv_user_icon) }
    }


}