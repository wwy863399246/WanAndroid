package com.wwy.android.data.repository.datasource

import com.wwy.android.data.api.RetrofitClient
import com.wwy.android.data.api.WAN_ANDROID
import com.wwy.android.data.bean.*
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.util.safeApiCall
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2020/6/3 15:19
 *@描述
 */
class RemoteDataSource {
    /**
     * 首页数据源
     * @param getHomeArticles 首页文章数据
     * @param getBanners 首页Banner数据
     * @param getStickArticles 首页置顶文章数据
     */
    suspend fun getHomeArticles(page: Int) = safeApiCall(
        call = { requestHomeArticles(page) }
    )

    suspend fun getBanners() = safeApiCall(
        call = { requestBanners() }
    )

    suspend fun getStickArticles() = safeApiCall(
        call = { requestStickArticles() }
    )

    private suspend fun requestHomeArticles(page: Int): ResultData<WanListResponse<List<Article>>> {
        val homeArticles = RetrofitClient(WAN_ANDROID).service.getHomeArticles(page)
        if (homeArticles.errorCode == 0) {
            return ResultData.Success(homeArticles.data)
        }
        return ResultData.Error(IOException("Failed to get homeArticles${homeArticles.errorMsg}"))
    }

    private suspend fun requestBanners(): ResultData<List<Banner>> {
        val banner = RetrofitClient(WAN_ANDROID).service.getBanner()
        if (banner.errorCode == 0) {
            return ResultData.Success(banner.data)
        }
        return ResultData.Error(IOException("Failed to get banners${banner.errorMsg}"))
    }

    private suspend fun requestStickArticles(): ResultData<List<Article>> {
        val stickArticles = RetrofitClient(WAN_ANDROID).service.getStickArticles()
        if (stickArticles.errorCode == 0) {
            return ResultData.Success(stickArticles.data)
        }
        return ResultData.Error(IOException("Failed to get stickArticles${stickArticles.errorMsg}"))
    }

    /**
     * 广场数据源
     *  @param getSquareArticleList 广场列表数据
     *  @param getBlogType 公众号分类
     *  @param getBlogArticle 项目tab下数据
     */
    suspend fun getSquareArticleList(page: Int) = safeApiCall(
        call = { requestSquareArticleList(page) }
    )

    suspend fun getBlogType() = safeApiCall(
        call = { requestBlogType() }
    )

    suspend fun getBlogDataByType(id: Int, page: Int) = safeApiCall(
        call = { requestBlogDataByType(id, page) }
    )

    private suspend fun requestSquareArticleList(page: Int): ResultData<WanListResponse<MutableList<Article>>> {
        val squareArticleList = RetrofitClient(WAN_ANDROID).service.getSquareArticleList(page)
        if (squareArticleList.errorCode == 0) {
            return ResultData.Success(squareArticleList.data)
        }
        return ResultData.Error(IOException("Failed to get squareArticleList${squareArticleList.errorMsg}"))
    }

    private suspend fun requestBlogType(): ResultData<MutableList<ClassifyResponse>> {
        val blogType = RetrofitClient(WAN_ANDROID).service.getBlogType()
        if (blogType.errorCode == 0) {
            return ResultData.Success(blogType.data)
        }
        return ResultData.Error(IOException("Failed to get blogType${blogType.errorMsg}"))
    }

    private suspend fun requestBlogDataByType(
        id: Int,
        page: Int
    ): ResultData<WanListResponse<MutableList<Article>>> {
        val blogDataByType = RetrofitClient(WAN_ANDROID).service.getBlogDataByType(id, page)
        if (blogDataByType.errorCode == 0) {
            return ResultData.Success(blogDataByType.data)
        }
        return ResultData.Error(IOException("Failed to get blogDataByType${blogDataByType.errorMsg}"))
    }

    /**
     * 项目数据源
     *  @param getProjectClassify 项目tab
     *  @param getLatestProjectList 最新项目列表数据
     *  @param getProjectTypeDetailList 项目tab下数据
     */

    suspend fun getProjectClassify() = safeApiCall(
        call = { requestProjectClassify() }
    )

    suspend fun getLatestProjectList(page: Int) = safeApiCall(
        call = { requestLatestProjectList(page) }
    )

    suspend fun getProjectTypeDetailList(page: Int, cid: Int) = safeApiCall(
        call = { requestProjectTypeDetailList(page, cid) }
    )

    private suspend fun requestProjectClassify(): ResultData<List<ClassifyResponse>> {
        val projectClassify = RetrofitClient(WAN_ANDROID).service.getProjectTypes()
        if (projectClassify.errorCode == 0) {
            return ResultData.Success(projectClassify.data)
        }
        return ResultData.Error(IOException("Failed to get projectClassify${projectClassify.errorMsg}"))
    }

    private suspend fun requestLatestProjectList(page: Int): ResultData<WanListResponse<MutableList<Article>>> {
        val projectNewData = RetrofitClient(WAN_ANDROID).service.getProjectNewData(page)
        if (projectNewData.errorCode == 0) {
            return ResultData.Success(projectNewData.data)
        }
        return ResultData.Error(IOException("Failed to get latestProjectList${projectNewData.errorMsg}"))
    }

    private suspend fun requestProjectTypeDetailList(
        page: Int,
        cid: Int
    ): ResultData<WanListResponse<List<Article>>> {
        val projectDataByType = RetrofitClient(WAN_ANDROID).service.getProjectDataByType(page, cid)
        if (projectDataByType.errorCode == 0) {
            return ResultData.Success(projectDataByType.data)
        }
        return ResultData.Error(IOException("Failed to get projectTypeDetailList${projectDataByType.errorMsg}"))
    }

    /**
     * 体系数据源
     *  @param getSystemType 体系tab
     *  @param getLatestProjectList 最新项目列表数据
     *  @param getProjectTypeDetailList 项目tab下数据
     */
    suspend fun getSystemType() = safeApiCall(
        call = { requestSystemType() }
    )

    private suspend fun requestSystemType(): ResultData<MutableList<ClassifyResponse>> {
        val systemType = RetrofitClient(WAN_ANDROID).service.getSystemType()
        if (systemType.errorCode == 0) {
            return ResultData.Success(systemType.data)
        }
        return ResultData.Error(IOException("Failed to get systemType${systemType.errorMsg}"))
    }

    /**
     * 导航数据源
     *  @param getNavigationData 导航数据
     */
    suspend fun getNavigationData() = safeApiCall(
        call = { requestNavigationData() }
    )

    private suspend fun requestNavigationData(): ResultData<MutableList<Navigation>> {
        val navigationData = RetrofitClient(WAN_ANDROID).service.getNavigationData()
        if (navigationData.errorCode == 0) {
            return ResultData.Success(navigationData.data)
        }
        return ResultData.Error(IOException("Failed to get navigationData${navigationData.errorMsg}"))
    }

    /**
     * 我的界面数据源
     * @param login 登录
     */
    suspend fun login(username: String, password: String) = safeApiCall(
        call = { requestLogin(username, password) }
    )

    private suspend fun requestLogin(username: String, password: String): ResultData<User> {
        val login = RetrofitClient(WAN_ANDROID).service.login(username, password)
        if (login.errorCode == 0) {
            return ResultData.Success(login.data)
        }
        return ResultData.ErrorMessage(login.errorMsg)
    }
    /**
     * 收藏与取消收藏
     * @param login 登录
     */
    suspend fun collect(id: Int) = safeApiCall(
        call = { requestCollect(id) }
    )

    private suspend fun requestCollect(id: Int): ResultData<Any> {
        val collect = RetrofitClient(WAN_ANDROID).service.collect(id)
        if (collect.errorCode == 0) {
            return ResultData.Success(collect.data.toString())
        }
        return ResultData.ErrorMessage(collect.errorMsg)
    }

    suspend fun unCollect(id: Int) = safeApiCall(
        call = { requestUnCollect(id) }
    )

    private suspend fun requestUnCollect(id: Int): ResultData<Any> {
        val unCollect = RetrofitClient(WAN_ANDROID).service.unCollect(id)
        if (unCollect.errorCode == 0) {
            return ResultData.Success(unCollect.data.toString())
        }
        return ResultData.ErrorMessage(unCollect.errorMsg)
    }
}