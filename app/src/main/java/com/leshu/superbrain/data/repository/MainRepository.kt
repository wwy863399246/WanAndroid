package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.Banner
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.HomeRemoteDataSource
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus
import java.net.UnknownHostException

/**
 *@创建者wwy
 *@创建时间 2020/1/13 16:20
 *@描述
 */
class MainRepository {
    private var currentPage = 0
    private val homeRemoteDataSource by lazy { HomeRemoteDataSource() }
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

    suspend fun getHomeArticles(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?
    ) {
        val loadPageStatus = MutableLiveData<LoadPageStatus>()
        if (currentPage == 0) {//开始加载
            loadPageStatus.postValue(LoadPageStatus.Loading)
            listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        }
        if (isRefresh) currentPage = 0
        val homeArticles = homeRemoteDataSource.getHomeArticles(currentPage)
        if (homeArticles is ResultData.Success) {
            val data = homeArticles.data
            if (data.datas.isNullOrEmpty() && currentPage == 0) {//开始加载无数据
                loadPageStatus.postValue(LoadPageStatus.Empty) //显示空界面
                listModel?.postValue(
                    ListModel(
                        showLoading = false,
                        loadPageStatus = loadPageStatus,
                        isRefresh = isRefresh
                    )
                )
                return
            }
            if (data.offset >= data.total) {//最后一页 showLoading 可以用来加载dialog
                listModel?.postValue(
                    ListModel(
                        showLoading = false,
                        showEnd = true,
                        isRefresh = isRefresh
                    )
                )
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
            if (homeArticles.exception is UnknownHostException) {//加载失败 这里可以区分失败原因，设置不同页面状态
                if (currentPage == 0) loadPageStatus.postValue(LoadPageStatus.NoNet)
            } else {
                if (currentPage == 0) loadPageStatus.postValue(LoadPageStatus.Fail)
            }
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showError = homeArticles.exception.message,
                    loadPageStatus = loadPageStatus,
                    isRefresh = isRefresh
                )
            )
        }
    }
}