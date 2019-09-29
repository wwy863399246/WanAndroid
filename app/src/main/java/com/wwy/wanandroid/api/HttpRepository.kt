package com.wwy.wanandroid.api

import android.annotation.SuppressLint
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

/**
 *@创建者wwy
 *@创建时间 2019/9/29 15:22
 *@描述
 */
object HttpRepository {
    var READ_TIME_OUT: Long = 5000
    var CONNECT_TIME_OUT: Long = 5000
    lateinit var mOkHttpClient: OkHttpClient.Builder
    private fun HttpRepository1(hostType: Int) {
        mOkHttpClient.readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
            .addInterceptor(mLoggingInterceptor)

    }

    @SuppressLint("BinaryOperationInTimber")
    private val mLoggingInterceptor = Interceptor { chain ->
        val request = chain.request()
        val t1 = System.nanoTime()
        val response = chain.proceed(chain.request())
        val t2 = System.nanoTime()
        val contentType = response.body()?.contentType()
        val content = response.body()?.string()
        Timber.tag("wwy").d( "request url:" + request.url() + "\ntime:" + (t2 - t1) / 1e6 + "\nbody:" + content + "\n")
        response.newBuilder()
            .body(okhttp3.ResponseBody.create(contentType, content))
            .build()


    }
}