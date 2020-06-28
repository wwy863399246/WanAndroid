package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.Banner
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus
import java.net.UnknownHostException

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