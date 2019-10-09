package com.wwy.wanandroid.repository.base

import com.wwy.wanandroid.bean.base.WanResponse
import kotlinx.coroutines.Deferred


/**
 * Created by wwy
 * on 2019/4/10 9:41
 */
open class BaseRepository {
    suspend fun <T : Any> apiCall(call: suspend () -> Deferred<WanResponse<T>>): Deferred<WanResponse<T>> {
        return call.invoke()
    }


}