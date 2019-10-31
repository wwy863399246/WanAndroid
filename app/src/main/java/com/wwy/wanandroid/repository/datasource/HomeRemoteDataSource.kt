package com.wwy.wanandroid.repository.datasource

import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.RetrofitClient
import com.wwy.wanandroid.bean.ArticleList
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.util.safeApiCall
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2019/10/30 9:54
 *@描述 首页远程数据类
 */
class HomeRemoteDataSource {
    suspend fun getHomeArticles(page: Int) = safeApiCall(
        call = { requestHomeArticles(page) }
    )

    suspend fun getBanners() = safeApiCall(
        call = { requestBanners() }
    )

    private suspend fun requestHomeArticles(page: Int): ResultData<ArticleList> {
        val homeArticles = RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.getHomeArticles(page)
        if (homeArticles.errorCode == 0) {
            return ResultData.Success(homeArticles.data)
        }
        return ResultData.Error(IOException("Failed to get homeArticles${homeArticles.errorMsg}"))
    }

    private suspend fun requestBanners(): ResultData<List<Banner>> {
        val banner = RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.getBanner()
        if (banner.errorCode == 0) {
            return ResultData.Success(banner.data)
        }
        return ResultData.Error(IOException("Failed to get banners${banner.errorMsg}"))
    }
}