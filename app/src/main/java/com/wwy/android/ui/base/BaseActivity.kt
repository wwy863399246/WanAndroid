package com.wwy.android.ui.base

import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.ext.getAppTheme
import com.wwy.android.ext.resourceId

/**
 *@创建者wwy
 *@创建时间 2019/10/9 11:08
 *@描述
 */
abstract class BaseActivity : AppCompatActivity() {


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
                    R.attr.colorPrimary,
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
            statusBarColor(TypedValue().resourceId(R.attr.colorPrimary, theme))
        }
    }


}