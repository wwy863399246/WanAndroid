package com.leshu.superbrain.repository.base

import com.leshu.superbrain.data.bean.base.WanResponse
import kotlinx.coroutines.*


/**
 * Created by wwy
 * on 2019/9/10 9:41
 */
open class BaseRepository {
    suspend fun <T : Any> apiCall(call: suspend () -> WanResponse<T>): WanResponse<T> {
        return withContext(Dispatchers.IO) { call.invoke() }.apply {
            when (errorCode) { //可以做一些特殊的异常处理
                -1001 -> throw LogonFailureException()
            }
        }
    }

    class LogonFailureException(msg: String = "Logon failure") : Exception(msg)
}