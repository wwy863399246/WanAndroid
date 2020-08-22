package com.wwy.android.ui.member

import androidx.navigation.fragment.findNavController
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_edit_data.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
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
            findNavController().popBackStack()
        }
        editDataNv.ivBackNavigationBar.clickWithTrigger {
            findNavController().popBackStack()
        }
    }

    override fun initData() {
    }

    override fun startObserve() {
    }
}