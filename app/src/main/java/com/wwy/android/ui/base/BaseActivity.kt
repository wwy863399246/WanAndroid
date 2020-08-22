package com.wwy.android.ui.base

import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.ext.getAppTheme
import com.wwy.android.ext.getNightMode
import com.wwy.android.ext.resourceId
import com.wwy.android.ui.main.ProgressDialogFragment

/**
 *@创建者wwy
 *@创建时间 2019/10/9 11:08
 *@描述
 */
abstract class BaseActivity : AppCompatActivity() {
    private lateinit var progressDialogFragment: ProgressDialogFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(getAppTheme())
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initImmersionBar()
        setSmartSnackBar()
        initActivity(savedInstanceState)
    }

    open fun setSmartSnackBar() {
        SmartSnackbar.setting()
            .backgroundColorRes(
                TypedValue().resourceId(
                    R.attr.colorAccent,
                    theme
                )
            )
            .dismissOnLeave(true)
    }

    protected open fun initActivity(savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
    }

    abstract fun setLayoutId(): Int
    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun initData()
    open fun initImmersionBar() {
        immersionBar {
            statusBarColor(
                TypedValue().resourceId(
                    R.attr.colorPrimary,
                    theme
                )
            ).autoStatusBarDarkModeEnable(true, 0.2f)
        }
    }

    /**
     * 显示加载(转圈)对话框
     */
    fun showProgressDialog(@StringRes message: Int) {
        if (!this::progressDialogFragment.isInitialized) {
            progressDialogFragment = ProgressDialogFragment.newInstance()
        }
        if (!progressDialogFragment.isAdded) {
            progressDialogFragment.show(supportFragmentManager, message, false)
        }
    }

    /**
     * 隐藏加载(转圈)对话框
     */
    fun dismissProgressDialog() {
        if (this::progressDialogFragment.isInitialized && progressDialogFragment.isVisible) {
            progressDialogFragment.dismissAllowingStateLoss()
        }
    }

}