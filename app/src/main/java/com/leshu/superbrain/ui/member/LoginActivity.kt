package com.leshu.superbrain.ui.member

import android.os.Bundle
import androidx.lifecycle.Observer
import com.leshu.superbrain.R
import com.leshu.superbrain.ui.base.BaseVMActivity
import com.leshu.superbrain.vm.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/17 10:23
 *@描述
 */
class LoginActivity : BaseVMActivity<LoginViewModel>() {
    override fun setLayoutId(): Int = R.layout.activity_login
    override fun initVM(): LoginViewModel = getViewModel()
    override fun initView(savedInstanceState: Bundle?) {
        loginButton.setOnClickListener {
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
            user.observe(this@LoginActivity, Observer {
                Timber.tag("wangwuyuan").d(user.value.toString())
            })
        }
    }


}