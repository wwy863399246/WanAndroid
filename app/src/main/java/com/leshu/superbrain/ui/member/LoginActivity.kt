package com.leshu.superbrain.ui.member

import android.os.Bundle
import androidx.lifecycle.Observer
import com.leshu.superbrain.R
import com.leshu.superbrain.ui.base.BaseVMActivity
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/17 10:23
 *@描述
 */
class LoginActivity : BaseVMActivity<LoginViewModel>() {
    override fun providerVMClass(): Class<LoginViewModel>? = LoginViewModel::class.java
    override fun setLayoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
        loginButton.setOnClickListener {
            mViewModel.login(userNameLayout.editText?.text.toString(), pswLayout.editText?.text.toString())
        }
    }


    override fun initData() {

    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.apply {
            user.observe(this@LoginActivity, Observer {
                Timber.tag("wangwuyuan").d(user.value.toString())
            })
        }
    }
}