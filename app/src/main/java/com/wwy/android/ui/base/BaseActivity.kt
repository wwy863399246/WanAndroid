package com.wwy.android.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R

/**
 *@创建者wwy
 *@创建时间 2019/10/9 11:08
 *@描述
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutId())
        initImmersionBar()
        initActivity(savedInstanceState)
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
            statusBarColor(R.color.colorPrimary)
        }
    }


}