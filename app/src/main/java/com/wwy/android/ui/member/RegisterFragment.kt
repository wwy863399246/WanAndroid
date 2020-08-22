package com.wwy.android.ui.member

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.resourceId
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.pswLayout
import kotlinx.android.synthetic.main.fragment_register.userNameLayout
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/7/17 13:49
 *@描述
 */
class RegisterFragment : BaseVMFragment<LoginViewModel>() {
    override fun initVM(): LoginViewModel = getViewModel()

    override fun startObserve() {
        mViewModel.run {
            mRegisterStatus.observe(viewLifecycleOwner, Observer {
                if (it.showLoading) showProgressDialog(R.string.register_loading) else dismissProgressDialog()
                if (it.showEnd) {
                    SmartSnackbar.get(activity).show(R.string.register_success)
                    findNavController().navigate(R.id.action_registerFragment_to_settingAvatarFragment)
                }
                it.showError?.let { errorMsg ->
                    SmartSnackbar.get(activity).show(errorMsg)
                }
            })
        }
    }

    override fun setLayoutResId(): Int = R.layout.fragment_register

    override fun initView() {
        settingAvatar.clickWithTrigger {
            findNavController().navigate(R.id.action_registerFragment_to_settingAvatarFragment)
        }
        registerNv.ivBackNavigationBar.clickWithTrigger {
            NavHostFragment.findNavController(this).popBackStack()
        }
        registerButton.clickWithTrigger {
            userNameLayout.error = ""
            pswLayout.error = ""
            againPswLayout.error = ""

            val account = userNameLayout.editText?.text.toString()
            val password = pswLayout.editText?.text.toString()
            val confirmPassword = againPswLayout.editText?.text.toString()

            when {
                account.isEmpty() -> userNameLayout.error = getString(R.string.account_can_not_be_empty)
                account.length < 3 -> userNameLayout.error =
                    getString(R.string.account_length_over_three)
                password.isEmpty() -> pswLayout.error =
                    getString(R.string.password_can_not_be_empty)
                password.length < 6 -> pswLayout.error =
                    getString(R.string.password_length_over_six)
                confirmPassword.isEmpty() -> againPswLayout.error =
                    getString(R.string.confirm_password_can_not_be_empty)
                password != confirmPassword -> againPswLayout.error =
                    getString(R.string.two_password_are_inconsistent)
                else -> mViewModel.register(account, password, confirmPassword)
            }
        }
    }

    override fun initData() {
    }
}