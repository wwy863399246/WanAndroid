package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.Config
import androidx.paging.toLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.db.AppDatabase
import com.leshu.superbrain.data.repository.datasource.HomeRemoteDataSource
import com.leshu.superbrain.util.*

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
        loadData(page, isNeedRefreshStatus)
        val livePagedList = articleDao.getArticleList().toLiveData(
            Config(pageSize = 20, enablePlaceholders = false),
            boundaryCallback = ListBoundaryCallback(listStatus)
        )

        return ListingModel(
            pagedList = livePagedList,
            listStatus = listStatus,
            retry = {},
            refresh = {}
        )
    }

    private suspend fun loadData(page: Int, isNeedRefreshStatus: Boolean) {
//        val refreshStatus = MutableLiveData<NetworkState>()//初始化刷新状态
//        val loadState = MutableLiveData<NetworkState>()//加载更多状态
//        refreshStatus.value = NetworkState.LOADING//数据初始化中.....
        if (isInternetAvailable()) {
            val homeArticlesData = remoteDataSource.getHomeArticles(page)
            if (homeArticlesData is ResultData.Success) {//在这里存存本地数据库
                val datas = homeArticlesData.data
                if (0 == page) {
                    articleDao.deleteAll()
                }
                articleDao.insert(datas)
                //  refreshStatus.value = NetworkState.LOADED//数据初始化完成.....
            } else {
                //  refreshStatus.value = NetworkState.FAILED//数据初始化失败.....
                //  loadState.value = NetworkState.FAILED//加载失败
            }
        }
//        return if (page == 0 && isNeedRefreshStatus) {
//            refreshStatus
//        } else {
//            loadState
//        }

    }


    suspend fun getBanners(): ResultData<List<BannerResponse>> {
        val banerData = remoteDataSource.getBanners()
        if (banerData is ResultData.Success) {//在这里存本地数据库
            return banerData
        }
        return banerData
    }
}