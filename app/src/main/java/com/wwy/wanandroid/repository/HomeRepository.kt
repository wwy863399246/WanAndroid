package com.wwy.wanandroid.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.Config
import androidx.paging.toLiveData
import com.wwy.wanandroid.bean.Article
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.db.AppDatabase
import com.wwy.wanandroid.repository.datasource.HomeRemoteDataSource
import com.wwy.wanandroid.util.*

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:13
 *@描述
 */
class HomeRepository {
    private val remoteDataSource by lazy { HomeRemoteDataSource() }
    private val articleDao = AppDatabase.getInstance().articleDao()

    suspend fun homeArticles(page: Int, isNeedRefreshStatus: Boolean): ListingModel<Article> {
        val listStatus = MutableLiveData<ListStatus>()
        val refreshStatus = loadData(page, isNeedRefreshStatus)
        val livePagedList = articleDao.getArticleList().toLiveData(
            Config(pageSize = 20, enablePlaceholders = false),
            boundaryCallback = ListBoundaryCallback(listStatus)
        )

        return ListingModel(
            pagedList = livePagedList,
            listStatus = listStatus,
            retry = {},
            refresh = {},
            refreshStatus = refreshStatus
        )
    }

    private suspend fun loadData(page: Int, isNeedRefreshStatus: Boolean): LiveData<NetworkState> {
        val refreshStatus = MutableLiveData<NetworkState>()//初始化刷新状态
        val loadState = MutableLiveData<NetworkState>()//加载更多状态
        refreshStatus.value = NetworkState.LOADING//数据初始化中.....
        if (isInternetAvailable()) {
            val homeArticlesData = remoteDataSource.getHomeArticles(page)
            if (homeArticlesData is ResultData.Success) {//在这里存存本地数据库
                val datas = homeArticlesData.data.datas
                if (0 == page) {
                    articleDao.deleteAll()
                }
                articleDao.insert(datas)
                refreshStatus.value = NetworkState.LOADED//数据初始化完成.....
            } else {
                refreshStatus.value = NetworkState.FAILED//数据初始化失败.....
                loadState.value = NetworkState.FAILED//加载失败
            }
        }
        return if (page == 0 && isNeedRefreshStatus) {
            refreshStatus
        } else {
            loadState
        }

    }


    suspend fun getBanners(): ResultData<List<Banner>> {
        val banerData = remoteDataSource.getBanners()
        if (banerData is ResultData.Success) {//在这里存本地数据库
            return banerData
        }
        return banerData
    }
}