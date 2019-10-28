package com.wwy.wanandroid.ui.member

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.lifecycle.Observer
import com.wwy.wanandroid.R
import com.wwy.wanandroid.ui.base.BaseActivity
import com.wwy.wanandroid.ui.base.BaseVMActivity
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/17 10:23
 *@描述
 */
class LoginActivity : BaseVMActivity<LoginViewModel>() {
    override fun setLayoutId(): Int = R.layout.activity_login

    override fun initView(savedInstanceState: Bundle?) {
    }


    override fun initData() {
        login.setOnClickListener {
            mViewModel.login(userNameLayout.editText?.text.toString(), pswLayout.editText?.text.toString())
        }
    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.apply {
            user.observe(this@LoginActivity, Observer {
                Timber.tag("wangwuyuan").d(user.toString())
            })
        }
    }
}