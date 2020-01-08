package com.leshu.superbrain.data.repository.datasource

import com.leshu.superbrain.data.api.RetrofitClient
import com.leshu.superbrain.data.api.WAN_ANDROID
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.util.safeApiCall
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

    private suspend fun requestHomeArticles(page: Int): ResultData<MutableList<Article>> {
        val homeArticles = RetrofitClient(WAN_ANDROID).service.getHomeArticles(page)
        if (homeArticles.errorCode == 0) {
            return ResultData.Success(homeArticles.data.datas)
        }
        return ResultData.Error(IOException("Failed to get homeArticles${homeArticles.errorMsg}"))
    }

    private suspend fun requestBanners(): ResultData<List<BannerResponse>> {
        val banner = RetrofitClient(WAN_ANDROID).service.getBanner()
        if (banner.errorCode == 0) {
            return ResultData.Success(banner.data)
        }
        return ResultData.Error(IOException("Failed to get banners${banner.errorMsg}"))
    }
}