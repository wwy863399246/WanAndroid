package com.wwy.android.ui.member

import android.util.TypedValue
import androidx.navigation.Navigation
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.resourceId
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_register.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/7/17 13:49
 *@描述
 */
class RegisterFragment : BaseVMFragment<LoginViewModel>() {
    override fun initVM(): LoginViewModel = getViewModel()

    override fun startObserve() {
    }

    override fun setLayoutResId(): Int = R.layout.fragment_register

    override fun initView() {
        immersionBar {
            titleBar(R.id.loginNb)
            statusBarColor(TypedValue().resourceId(R.attr.colorPrimary,requireActivity().theme))
        }
        settingAvatar.clickWithTrigger {
            Navigation.findNavController(it)
                .navigate(R.id.action_registerFragment_to_settingAvatarFragment)
        }
    }

    override fun initData() {
    }
}