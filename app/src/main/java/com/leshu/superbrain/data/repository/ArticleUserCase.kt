package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus
import java.net.UnknownHostException

class ArticleUserCase(private val remoteDataSource: RemoteDataSource) {
    private var currentPage = 0

    sealed class ArticleType {
        object Home : ArticleType()                 // 首页
        object Square : ArticleType()               // 广场
        object LatestProject : ArticleType()        // 最新项目
        object ProjectDetailList : ArticleType()    // 项目列表
        object Collection : ArticleType()           // 收藏
        object SystemType : ArticleType()           // 体系分类
        object Blog : ArticleType()                 // 公众号
    }

    suspend fun getHomeArticleList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) = getArticleList(ArticleType.Home, isRefresh, listModel, loadPageStatus)

    suspend fun getSquareArticleList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) = getArticleList(ArticleType.Square, isRefresh, listModel, loadPageStatus)

    suspend fun getLatestProjectList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) = getArticleList(ArticleType.LatestProject, isRefresh, listModel, loadPageStatus)

    suspend fun getProjectTypeDetailList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>,
        cid: Int
    ) = getArticleList(ArticleType.ProjectDetailList, isRefresh, listModel, loadPageStatus, cid)

    suspend fun getCollectArticleList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) = getArticleList(ArticleType.Collection, isRefresh, listModel, loadPageStatus)

    suspend fun getSystemTypeArticleList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>,
        cid: Int
    ) = getArticleList(ArticleType.SystemType, isRefresh, listModel, loadPageStatus, cid)

    suspend fun getBlogArticleList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>,
        cid: Int
    ) = getArticleList(ArticleType.Blog, isRefresh, listModel, loadPageStatus, cid)

    private suspend fun getArticleList(
        articleType: ArticleType,
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>,
        cid: Int = 0
    ) {
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        if (isRefresh) currentPage = if (articleType is ArticleType.ProjectDetailList) 1 else 0
        val result = when (articleType) {
            ArticleType.Home -> remoteDataSource.getHomeArticles(currentPage)
            ArticleType.Square -> remoteDataSource.getSquareArticleList(currentPage)
            ArticleType.LatestProject -> remoteDataSource.getLatestProjectList(currentPage)
            ArticleType.ProjectDetailList -> remoteDataSource.getProjectTypeDetailList(
                currentPage,
                cid
            )
            ArticleType.Collection -> remoteDataSource.getHomeArticles(currentPage)
            ArticleType.SystemType -> remoteDataSource.getHomeArticles(currentPage)
            ArticleType.Blog -> remoteDataSource.getBlogDataByType(cid,currentPage)
        }
        if (result is ResultData.Success) {
            val data = result.data
            if (data.datas.isNullOrEmpty() && currentPage == 0) {//开始加载无数据
                loadPageStatus.postValue(LoadPageStatus.Empty) //显示空界面
                listModel?.postValue(
                    ListModel(
                        isRefreshSuccess = false,
                        loadPageStatus = loadPageStatus,
                        isRefresh = isRefresh
                    )
                )
                return
            }
            if (data.offset >= data.total) {//最后一页 showLoading 可以用来加载dialog
                listModel?.postValue(
                    ListModel(
                        isRefreshSuccess = true,
                        showEnd = true,
                        isRefresh = isRefresh
                    )
                )
                return
            }
            currentPage++
            listModel?.postValue(
                ListModel(
                    isRefreshSuccess = true,
                    showSuccess = result.data.datas,
                    isRefresh = isRefresh
                )
            )
        } else if (result is ResultData.Error) {
            if (result.exception is UnknownHostException) {//加载失败 这里可以区分失败原因，设置不同页面状态
                if (currentPage == 0) loadPageStatus.postValue(LoadPageStatus.NoNet)
            } else {
                if (currentPage == 0) loadPageStatus.postValue(LoadPageStatus.Fail)
            }
            listModel?.postValue(
                ListModel(
                    isRefreshSuccess = false,
                    showError = result.exception.message,
                    loadPageStatus = loadPageStatus,
                    isRefresh = isRefresh
                )
            )
        }
    }
}