package com.wwy.android.app

import android.app.Application
import android.app.UiModeManager
import android.content.Context
import android.util.TypedValue
import com.chad.library.adapter.base.module.LoadMoreModuleConfig.defLoadMoreView
import com.coder.zzq.smartshow.core.SmartShow
import com.jeremyliao.liveeventbus.LiveEventBus
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.tencent.mmkv.MMKV
import com.wwy.android.BuildConfig
import com.wwy.android.R
import com.wwy.android.ext.getNightMode
import com.wwy.android.ext.resourceId
import com.wwy.android.util.ActivityHelper
import com.wwy.android.view.roundview.CustomLoadMoreView
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber
import kotlin.properties.Delegates


/**
 *@创建者wwy
 *@创建时间 2019/10/9 16:12
 *@描述
 */
class MyApplication : Application() {
    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        ActivityHelper.init(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MyApplication)
            modules(appModule)
        }
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(
                TypedValue().resourceId(R.attr.colorPrimary, context.theme),
                TypedValue().resourceId(R.attr.textColorPrimary, context.theme)
            ) //全局设置主题颜色
            ClassicsHeader(context) //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
        defLoadMoreView = CustomLoadMoreView()
        MMKV.initialize(this)
        LiveEventBus.config()
        SmartShow.init(this)
        (getSystemService(Context.UI_MODE_SERVICE) as UiModeManager).nightMode=getNightMode()
    }
}