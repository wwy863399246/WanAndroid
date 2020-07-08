package com.wwy.android.data.repository

import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.Banner
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2020/1/13 16:20
 *@描述
 */
class MainRepository(private val homeRemoteDataSource: RemoteDataSource) {
    private var currentPage = 0

    suspend fun getBanners(): ResultData<List<Banner>> {
        val bannerData = homeRemoteDataSource.getBanners()
        if (bannerData is ResultData.Success) {
            return bannerData
        }
        return bannerData
    }

    suspend fun getStickArticles(): ResultData<List<Article>> {
        val stickArticles = homeRemoteDataSource.getStickArticles()
        if (stickArticles is ResultData.Success) {
            return stickArticles
        }
        return stickArticles
    }
}