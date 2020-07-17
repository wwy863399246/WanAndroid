package com.wwy.android.ui.member

import android.os.Bundle
import androidx.lifecycle.Observer
import com.wwy.android.R
import com.wwy.android.ui.base.BaseActivity
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.vm.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/17 10:23
 *@描述
 */
class LoginActivity : BaseActivity() {
    override fun setLayoutId(): Int = R.layout.activity_login
    override fun initView(savedInstanceState: Bundle?) {
    }

    override fun initData() {

    }

}