package com.wwy.wanandroid.util

import java.io.IOException
import com.wwy.wanandroid.bean.base.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2019/10/25 16:09
 *@描述 网络请求类
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>): Result<T> {
    return withContext(Dispatchers.IO) { call.invoke() }
}

