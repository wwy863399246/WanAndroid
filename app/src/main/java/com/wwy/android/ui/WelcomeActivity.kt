package com.wwy.android.ui

import android.content.Intent
import android.os.Bundle
import com.wwy.android.R
import com.wwy.android.ui.base.BaseActivity
import com.wwy.android.ui.main.MainActivity
import kotlinx.coroutines.*
import org.jetbrains.anko.startActivity


/**
 *@创建者wwy
 *@创建时间 2019/12/13 17:53
 *@描述
 */
class WelcomeActivity : BaseActivity(), CoroutineScope by MainScope() {
    override fun setLayoutId(): Int = R.layout.activity_welcome

    override fun initView(savedInstanceState: Bundle?) {
        startMainActivity()
    }

    override fun initData() {}

    private fun startMainActivity() {
        startActivity<MainActivity>()
        finish()
    }

    /**
     * 重启app
     */
    private fun restartApp() {
        val launchIntent = packageManager.getLaunchIntentForPackage(application.packageName)
        launchIntent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(launchIntent)
    }
}