package com.leshu.superbrain

import android.content.Intent
import android.os.Bundle
import com.coder.zzq.smartshow.dialog.LoadingDialog
import com.leshu.superbrain.ui.base.BaseActivity
import com.leshu.superbrain.ui.main.MainActivity
import kotlinx.coroutines.*
import org.jetbrains.anko.startActivity


/**
 *@创建者wwy
 *@创建时间 2019/12/13 17:53
 *@描述
 */
class WelcomeActivity : BaseActivity(), CoroutineScope by MainScope() {
    private var mLoadingDialog: LoadingDialog? = null
    override fun setLayoutId(): Int = R.layout.activity_welcome

    override fun initView(savedInstanceState: Bundle?) {
        startMainActivity()
    }

    override fun initData() {}

    private fun startMainActivity() {
        GlobalScope.launch(Dispatchers.IO) {
            delay(500)
            startActivity<MainActivity>()
            finish()
        }
    }


    /**
     * 重启app
     */
    private fun restartApp() {
        val launchIntent = packageManager.getLaunchIntentForPackage(application.packageName)
        launchIntent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(launchIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}