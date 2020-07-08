package com.wwy.android.app

import android.app.Application
import android.content.Context
import com.coder.zzq.smartshow.core.SmartShow
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.BuildConfig
import com.wwy.android.R
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
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
            layout.setPrimaryColorsId(R.color.colorPrimary, R.color.color_FFFFFF) //全局设置主题颜色
            ClassicsHeader(context) //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
        LiveEventBus.config()
        SmartShow.init(this)
        SmartSnackbar.setting()
            .backgroundColorRes(R.color.colorPrimary)
            .dismissOnLeave(true)
    }
}