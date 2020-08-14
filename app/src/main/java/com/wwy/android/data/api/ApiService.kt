package com.wwy.android.data.api

import com.wwy.android.data.bean.*
import com.wwy.android.data.bean.base.WanResponse
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
    suspend fun login(
        @Field("username") userName: String,
        @Field("password") passWord: String
    ): WanResponse<User>

    /**
     * 获取banner数据
     */
    @GET("/banner/json")
    suspend fun getBanner(): WanResponse<MutableList<Banner>>

    /**
     * 获取首页文章数据
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): WanResponse<WanListResponse<List<Article>>>

    /**
     * 获取置顶文章数据
     */
    @GET("/article/top/json")
    suspend fun getStickArticles(): WanResponse<List<Article>>

    /**
     * 项目分类
     */
    @GET("/project/tree/json")
    suspend fun getProjectTypes(): WanResponse<MutableList<ClassifyResponse>>

    /**
     * 根据分类id获取项目数据
     */
    @GET("/project/list/{page}/json")
    suspend fun getProjectDataByType(
        @Path("page") pageNo: Int,
        @Query("cid") cid: Int
    ): WanResponse<WanListResponse<List<Article>>>

    /**
     * 获取最新项目数据
     */
    @GET("/article/listproject/{page}/json")
    suspend fun getProjectNewData(@Path("page") pageNo: Int): WanResponse<WanListResponse<MutableList<Article>>>

    /**
     * 获取广场数据
     */
    @GET("/user_article/list/{page}/json")
    suspend fun getSquareArticleList(@Path("page") page: Int): WanResponse<WanListResponse<MutableList<Article>>>

    /**
     * 获取公众号分类
     */
    @GET("/wxarticle/chapters/json")
    suspend fun getBlogType(): WanResponse<MutableList<ClassifyResponse>>

    /**
     * 获取公众号分类下的数据
     */
    @GET("/wxarticle/list/{id}/{page}/json")
    suspend fun getBlogDataByType(
        @Path("id") id: Int,
        @Path("page") page: Int
    ): WanResponse<WanListResponse<MutableList<Article>>>

    /**
     * 获取体系数据
     */
    @GET("/tree/json")
    suspend fun getSystemType(): WanResponse<MutableList<ClassifyResponse>>

    /**
     * 获取导航数据
     */
    @GET("/navi/json")
    suspend fun getNavigationData(): WanResponse<MutableList<Navigation>>

    /**
     * 收藏
     */
    @POST("lg/collect/{id}/json")
    suspend fun collect(@Path("id") id: Int): WanResponse<Any?>

    /**
     * 取消收藏
     */
    @POST("lg/uncollect_originId/{id}/json")
    suspend fun unCollect(@Path("id") id: Int): WanResponse<Any?>
}