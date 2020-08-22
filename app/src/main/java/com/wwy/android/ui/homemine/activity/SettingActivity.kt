package com.wwy.android.ui.homemine.activity

import android.app.UiModeManager
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.gyf.immersionbar.ktx.immersionBar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseActivity
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.util.clearCache
import com.wwy.android.util.getCacheSize
import com.wwy.android.vm.SettingViewModel
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.noButton
import org.jetbrains.anko.textColor
import org.jetbrains.anko.yesButton
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.properties.Delegates

/**
 *@创建者wwy
 *@创建时间 2020/8/17 0017 下午 23:26
 *@描述
 */
class SettingActivity : BaseVMActivity<SettingViewModel>() {
    override fun setLayoutId(): Int = R.layout.activity_settings
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.settingNv)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        settingNv.run {
            setLeftTitleNavigationBarText(R.string.setting)
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        tvLogout.isVisible = isLogin()
        tvLogout.clickWithTrigger {
            mViewModel.loginOut()
        }
        tvClearCache.text = getCacheSize(this)
        llClearCache.clickWithTrigger {
            val dialog = AlertDialog.Builder(this)
                .setMessage(R.string.confirm_clear_cache)
                .setPositiveButton(R.string.confirm) { _, _ ->
                    clearCache(this@SettingActivity)
                    tvClearCache.text = getCacheSize(this@SettingActivity)
                }
                .setNegativeButton(R.string.cancel) { _, _ -> }
                .show()
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).textColor = color(TypedValue().resourceId(R.attr.colorAccent,theme))
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).textColor = color(TypedValue().resourceId(R.attr.colorAccent,theme))
        }
        llCheckVersion.clickWithTrigger {
            SmartSnackbar.get(this).show(R.string.stay_tuned)
        }
        tvAboutUs.text = String.format(text(R.string.current_version), packageInfo().versionName)
        val modeNightAuto = (getNightMode() == UiModeManager.MODE_NIGHT_AUTO)
        scDayNight.isChecked = modeNightAuto
        scDayNight.setOnCheckedChangeListener { _, check ->
            setNightMode(if (check) UiModeManager.MODE_NIGHT_AUTO else getLastNightMode())
            setIsCheck(true)
            (getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode = if (check)
                UiModeManager.MODE_NIGHT_AUTO else getLastNightMode()
        }
        llSetUserMsg.clickWithTrigger {
            SmartSnackbar.get(this).show(R.string.stay_tuned)
        }
    }

    override fun initData() {

    }


    override fun initVM(): SettingViewModel = getViewModel()

    override fun startObserve() {
        mViewModel.run {
            mLoginStatus.observe(this@SettingActivity, Observer {
                if (it.showLoading) showProgressDialog(R.string.loading) else dismissProgressDialog()
                if (it.showEnd) {
                    setLoginState(false)
                    CookieClass.clearCookie()
                    finish()
                }
            })
        }
    }
}