package com.wwy.wanandroid.api

import com.wwy.wanandroid.bean.ArticleList
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.SystemParent
import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.bean.base.WanResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:23
 *@描述
 */
interface ApiService {
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username")userName: String,@Field("password")passWord: String) : WanResponse<User>
    @GET("/banner/json")
    suspend fun getBanner(): WanResponse<List<Banner>>
    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): WanResponse<ArticleList>
    @GET("/tree/json")
    suspend fun getSystemType(): WanResponse<List<SystemParent>>
}