package com.wwy.android.ui.member

import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_edit_data.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/7/17 14:10
 *@描述
 */
class EditDataFragment : BaseVMFragment<LoginViewModel>() {
    override fun initVM(): LoginViewModel = getViewModel()

    override fun setLayoutResId(): Int = R.layout.fragment_edit_data

    override fun initView() {

        settingAvatarButton.clickWithTrigger {
            activity?.finish()
        }
    }

    override fun initData() {
    }
    override fun startObserve() {
    }
}