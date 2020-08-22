package com.wwy.android.ui.member

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.hideSoftInput
import com.wwy.android.ext.resourceId
import com.wwy.android.ext.viewModel
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.activity_share.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2020/7/17 13:33
 *@描述
 */
class LoginFragment : BaseVMFragment<LoginViewModel>() {
    override fun initVM(): LoginViewModel = getViewModel()

    override fun setLayoutResId(): Int = R.layout.fragment_login

    override fun initView() {
        loginNv.ivBackNavigationBar.clickWithTrigger {
            requireActivity().finish()
        }
        goRegister.clickWithTrigger {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)
        }
        loginButton.clickWithTrigger {
            it.hideSoftInput()
            mViewModel.login(
                userNameLayout.editText?.text.toString(),
                pswLayout.editText?.text.toString()
            )
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
        mViewModel.run {
            mLoginStatus.observe(viewLifecycleOwner, Observer {
                if (it.showLoading) showProgressDialog(R.string.login_loading) else dismissProgressDialog()
                if (it.showEnd) {
                    SmartSnackbar.get(activity).show(R.string.login_success)
                    requireActivity().finish()
                }
                it.showError?.let { errorMsg ->
                    SmartSnackbar.get(activity).show(errorMsg)
                }
            })
        }
    }

}
