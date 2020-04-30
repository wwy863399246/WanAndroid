package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.HomeRemoteDataSource
import com.leshu.superbrain.util.ListModel
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2020/1/13 16:20
 *@描述
 */
class MainRepository {
    private var currentPage = 0
    private val homeRemoteDataSource by lazy { HomeRemoteDataSource() }
    suspend fun getBanners(): ResultData<List<BannerResponse>> {
        val bannerData = homeRemoteDataSource.getBanners()
        if (bannerData is ResultData.Success) {
            return bannerData
        }
        return bannerData
    }

    suspend fun getHomeArticles(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?
    ) {
        if (isRefresh) currentPage = 0
        val homeArticles = homeRemoteDataSource.getHomeArticles(currentPage)
        if (homeArticles is ResultData.Success) {
            val data = homeArticles.data
            if (data.offset >= data.total) {//最后一页
                listModel?.postValue(ListModel(showLoading = false, showEnd = true))
                return
            }
            currentPage++
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showSuccess = homeArticles.data.datas,
                    isRefresh = isRefresh
                )
            )
        } else if (homeArticles is ResultData.Error) {
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showError = homeArticles.exception.message
                )
            )
        }
    }
}