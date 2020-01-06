package com.leshu.superbrain.data.api

/**
 *@创建者wwy
 *@创建时间 2019/10/8 10:58
 *@描述
 */
open class ApiConstants {

      private val wanAndroidUrl= "https://www.wanandroid.com"

    open fun getHost(hostType: Int): String {
        lateinit var host: String
        when (hostType) {
            HostType.WAN_ANDROID -> host = wanAndroidUrl
        }
        return host
    }

}