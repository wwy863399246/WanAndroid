package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import java.net.UnknownHostException

class ArticleUserCase(private val remoteDataSource: RemoteDataSource) {
    private var currentPage = 0
    private var currentKeywords = ""

    sealed class ArticleType {
        object Home : ArticleType()                 // 首页
        object Square : ArticleType()               // 广场
        object LatestProject : ArticleType()        // 最新项目
        object ProjectDetailList : ArticleType()    // 项目列表
        object Collection : ArticleType()           // 收藏
        object SystemType : ArticleType()           // 体系分类
        object Blog : ArticleType()                 // 公众号
        object Share : ArticleType()                 // 分享
        object Search : ArticleType()                 // 文章搜索
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

    suspend fun getShareArticleList(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) = getArticleList(ArticleType.Share, isRefresh, listModel, loadPageStatus)

    suspend fun getSearchArticleList(
        keywords: String = currentKeywords,
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) {
        if (currentKeywords != keywords) {
            currentKeywords = keywords
        }
        getArticleList(ArticleType.Search, isRefresh, listModel, loadPageStatus, 0, keywords)
    }

    private suspend fun getArticleList(
        articleType: ArticleType,
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>,
        cid: Int = 0,
        keywords: String = ""
    ) {
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        if (isRefresh) currentPage =
            if (articleType is ArticleType.ProjectDetailList || articleType is ArticleType.Share) 1 else 0
        val result = when (articleType) {
            ArticleType.Home -> remoteDataSource.getHomeArticles(currentPage)
            ArticleType.Square -> remoteDataSource.getSquareArticleList(currentPage)
            ArticleType.LatestProject -> remoteDataSource.getLatestProjectList(currentPage)
            ArticleType.ProjectDetailList -> remoteDataSource.getProjectTypeDetailList(
                currentPage,
                cid
            )
            ArticleType.Collection -> remoteDataSource.getCollectionList(currentPage)
            ArticleType.SystemType -> remoteDataSource.getHomeArticles(currentPage)
            ArticleType.Blog -> remoteDataSource.getBlogDataByType(cid, currentPage)
            ArticleType.Share -> remoteDataSource.getSharedArticleList(currentPage)
            ArticleType.Search -> remoteDataSource.searchArticle(keywords, currentPage)
        }
        if (result is ResultData.Success) {
            val data = result.data
            if (data.datas.isNullOrEmpty() && currentPage == if (articleType is ArticleType.ProjectDetailList || articleType is ArticleType.Share) 1 else 0) {//开始加载无数据
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
            if (data.offset >= data.total) {//最后一页  showLoading 可以用来加载dialog
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