package com.wwy.wanandroid.api

import okhttp3.OkHttpClient

/**
 *@创建者wwy
 *@创建时间 2019/10/9 19:03
 *@描述
 */
object RetrofitClient : BaseRetrofitClient() {
    open class RetrofitClient(hostType: Int) {
        val service by lazy { getService(ApiService::class.java, hostType) }
    }

    //okhttp 扩展
    override fun handleBuilder(builder: OkHttpClient.Builder) {

    }
}