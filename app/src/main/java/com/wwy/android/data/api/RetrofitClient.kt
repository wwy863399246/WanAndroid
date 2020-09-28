package com.wwy.android.data.api

import com.wwy.android.ext.CookieClass.cookieJar
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *@创建者wwy
 *@创建时间 2019/10/9 19:03
 *@描述
 */
class RetrofitClient private constructor(hostType: Int) : BaseRetrofitClient() {
    val service by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        getService(ApiService::class.java, hostType)
    }

    companion object {
        @Volatile
        private var instance: RetrofitClient? = null
        fun getInStance(hostType: Int) = instance ?: synchronized(this) {
            instance ?: RetrofitClient(hostType).also { instance = it }
        }

    }

    //okHttp 扩展
    override fun handleBuilder(builder: OkHttpClient.Builder) {
        builder.cookieJar(cookieJar)
    }
    //retrofit扩展
    override fun retrofitBuilder(builder: Retrofit.Builder) {
    }
}