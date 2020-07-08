package com.wwy.android.ui.homemine

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import com.wwy.android.R
import com.wwy.android.ext.color
import com.wwy.android.ui.base.BaseFragment
import com.wwy.android.ui.member.LoginActivity
import com.wwy.android.util.GlideImageLoader
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

        progress.indeterminateTintList =
            activity?.color(R.color.colorPrimary)?.let { ColorStateList.valueOf(it) }
        progress.indeterminateTintMode = PorterDuff.Mode.SRC_ATOP
        activity?.let { GlideImageLoader().displayCircleImage(it, R.drawable.logo, iv_user_icon) }
        iv_user_icon.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
    }


}

