package com.wwy.android.ui.member

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.resourceId
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
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
        goRegister.clickWithTrigger {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)
        }
        loginButton.clickWithTrigger {
            mViewModel.login(
                userNameLayout.editText?.text.toString(),
                pswLayout.editText?.text.toString()
            )
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
        mViewModel.apply {
            user.observe(viewLifecycleOwner, Observer {
                requireActivity().finish()
            })
            loginErrorMsg.observe(viewLifecycleOwner, Observer {
                SmartSnackbar.get(activity).show(it)
            })
        }
    }

}