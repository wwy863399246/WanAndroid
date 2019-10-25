package com.wwy.wanandroid.repository.base

import com.wwy.wanandroid.bean.base.WanResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2019/10/25 16:09
 *@描述
 */
open class BaseRemoteDataSource {

    suspend fun <T : Any> safeApiCall(call: suspend () -> WanResponse<T>): WanResponse<T> {
        return call()
    }

    suspend fun <T : Any> apiCall(call: suspend () -> WanResponse<T>): WanResponse<T> {
        return withContext(Dispatchers.IO) { call.invoke() }.apply {
            when (errorCode) { //可以做一些特殊的异常处理
                -1001 -> throw LogonFailureException()
            }
        }
    }

    class LogonFailureException(msg: String = "Logon failure") : Exception(msg)
}