package com.wwy.wanandroid.util

import com.wwy.wanandroid.bean.base.WanResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2019/10/25 16:09
 *@描述 网络请求类
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> WanResponse<T>): WanResponse<T> {
    return call()
}

