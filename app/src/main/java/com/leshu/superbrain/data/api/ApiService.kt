package com.leshu.superbrain.data.api

import com.leshu.superbrain.data.bean.*
import com.leshu.superbrain.data.bean.base.WanResponse
import retrofit2.http.*

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:23
 *@描述
 */
interface ApiService {
    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username")userName: String,@Field("password")passWord: String) : WanResponse<User>
    /**
     * 获取banner数据
     */
    @GET("/banner/json")
    suspend fun getBanner(): WanResponse<MutableList<BannerResponse>>
    /**
     * 获取首页文章数据
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): WanResponse<WanListResponse<MutableList<Article>>>
    /**
     * 项目分类
     */
    @GET("/project/tree/json")
    suspend fun getProjecTypes(): WanResponse<MutableList<ClassifyResponse>>

    /**
     * 根据分类id获取项目数据
     */
    @GET("/project/list/{page}/json")
    fun getProjecDataByType(@Path("page") pageNo: Int, @Query("cid") cid: Int): WanResponse<WanListResponse<MutableList<AriticleResponse>>>

    /**
     * 获取最新项目数据
     */
    @GET("/article/listproject/{page}/json")
    fun getProjecNewData(@Path("page") pageNo: Int): WanResponse<WanListResponse<MutableList<AriticleResponse>>>
}