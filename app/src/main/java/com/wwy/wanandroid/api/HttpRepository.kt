package com.wwy.wanandroid.api

import android.annotation.SuppressLint
import android.util.Log
import android.util.SparseArray
import com.google.gson.GsonBuilder
import com.wwy.wanandroid.ext.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    lateinit var mApiService: ApiService
    private lateinit var retrofit: Retrofit
    private val mRetrofitManager = SparseArray<HttpRepository>(HostType.TYPE_COUNT)
    private fun HttpRepository(hostType: Int) {
        retrofit = Retrofit.Builder()
            .client(provideOkHttpClient(mLoggingInterceptor))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(ApiConstants().getHost(hostType))
            .build()
        mApiService = retrofit.create(ApiService::class.java)
    }

    private fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder().readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS).connectTimeout(
            CONNECT_TIME_OUT,
            TimeUnit.MILLISECONDS
        ).apply { addInterceptor(interceptor) }.build()

    @SuppressLint("BinaryOperationInTimber")
    private val mLoggingInterceptor = Interceptor { chain ->
        val request = chain.request()
        val t1 = System.nanoTime()
        val response = chain.proceed(chain.request())
        val t2 = System.nanoTime()
        val contentType = response.body()?.contentType()
        val content = response.body()?.string()
        Timber.tag("wwy").d("request url:" + request.url() + "\ntime:" + (t2 - t1) / 1e6 + "\nbody:" + content + "\n")
        response.newBuilder()
            .body(okhttp3.ResponseBody.create(contentType, content))
            .build()


    }

    fun getDefault(hostType: Int): ApiService {
        val retrofitManager: HttpRepository = mRetrofitManager.get(hostType)
        mRetrofitManager.put(hostType, retrofitManager)

        return retrofitManager.mApiService
    }

}