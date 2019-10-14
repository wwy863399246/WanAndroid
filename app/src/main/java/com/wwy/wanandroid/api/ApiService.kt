package com.wwy.wanandroid.api

import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.SystemParent
import com.wwy.wanandroid.bean.base.WanResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:23
 *@描述
 */
interface ApiService {
    @GET("/banner/json")
    suspend fun getBanner(): WanResponse<List<Banner>>
    @GET("/tree/json")
    suspend fun getSystemType(): WanResponse<List<SystemParent>>
}