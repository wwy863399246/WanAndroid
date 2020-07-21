package com.wwy.android.ui.member

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.resourceId
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_setting_avatar.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/7/17 14:10
 *@描述
 */
class SettingAvatarFragment : BaseVMFragment<LoginViewModel>() {
    override fun initVM(): LoginViewModel = getViewModel()

    override fun startObserve() {
    }


    override fun setLayoutResId(): Int = R.layout.fragment_setting_avatar

    override fun initView() {
        immersionBar {
            titleBar(R.id.toolbar)
//            statusBarColor(TypedValue().resourceId(R.attr.colorPrimary,requireActivity().theme))
            statusBarAlpha(0f)
        }
        settingAvatarButton.clickWithTrigger {
            activity?.finish()
        }
    }

    override fun initData() {
    }
}