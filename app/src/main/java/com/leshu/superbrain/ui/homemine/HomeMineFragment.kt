package com.leshu.superbrain.ui.homemine

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import com.leshu.superbrain.R
import com.leshu.superbrain.ext.color
import com.leshu.superbrain.ui.base.BaseFragment
import com.leshu.superbrain.ui.member.LoginActivity
import com.leshu.superbrain.util.GlideImageLoader
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

