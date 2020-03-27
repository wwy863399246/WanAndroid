package com.leshu.superbrain.data.repository

import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.HomeRemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2020/1/13 16:20
 *@描述
 */
class MainRepository {
    private val homeRemoteDataSource by lazy { HomeRemoteDataSource() }
    suspend fun getBanners(): ResultData<List<BannerResponse>> {
        val bannerData = homeRemoteDataSource.getBanners()
        if (bannerData is ResultData.Success) {
            return bannerData
        }
        return bannerData
    }

    suspend fun getHomeArticles(page: Int): ResultData<List<Article>> {
        val bannerData = homeRemoteDataSource.getHomeArticles(page)
        if (bannerData is ResultData.Success) {
            return bannerData
        }
        return bannerData
    }
}