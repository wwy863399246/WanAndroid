package com.wwy.android.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.wwy.android.app.MyApplication
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.bean.base.ResultDataFlow
import kotlinx.coroutines.flow.Flow

/**
 *@创建者wwy
 *@创建时间 2019/10/25 16:09
 *@描述 网络请求类
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> ResultData<T>): ResultData<T> {
    return try {
        call()
    } catch (e: Exception) {
        ResultData.Error(e)
    }
}
/**
 * 判断网络状态是否可用
 */

@Suppress("DEPRECATION")
fun isInternetAvailable(): Boolean {
    var result = false
    val cm = MyApplication.CONTEXT.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        }
    } else {
        cm?.run {
            cm.activeNetworkInfo?.run {
                if (type == ConnectivityManager.TYPE_WIFI) {
                    result = true
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    result = true
                }
            }
        }
    }
    return result
}

