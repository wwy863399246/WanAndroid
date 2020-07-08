package com.wwy.android.data.api

/**
 *@创建者wwy
 *@创建时间 2019/10/8 10:58
 *@描述
 */
const val WAN_ANDROID = 1
const val wanAndroidUrl = "https://www.wanandroid.com"

fun getHost(hostType: Int): String {
    lateinit var host: String
    when (hostType) {
        WAN_ANDROID -> host = wanAndroidUrl
    }
    return host
}
