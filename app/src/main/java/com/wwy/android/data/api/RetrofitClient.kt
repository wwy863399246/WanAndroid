package com.wwy.android.data.api

import com.wwy.android.ext.CookieClass.cookieJar
import okhttp3.OkHttpClient

/**
 *@创建者wwy
 *@创建时间 2019/10/9 19:03
 *@描述
 */
class RetrofitClient(hostType: Int) : BaseRetrofitClient() {
    val service by lazy { getService(ApiService::class.java, hostType) }

    //okhttp 扩展
    override fun handleBuilder(builder: OkHttpClient.Builder) {
        builder.cookieJar(cookieJar)
    }
}