package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.Banner
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.ArticleUserCase
import com.wwy.android.data.repository.MainRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/1/13 14:24
 *@描述
 */
class HomePageViewModel(private val mainRepository : MainRepository, private val articleUserCase:ArticleUserCase) : BaseViewModel() {
    val mBanner: MutableLiveData<List<Banner>> = MutableLiveData()
    val mListModel = MutableLiveData<ListModel<Article>>()
    private val loadPageStatus = MutableLiveData<LoadPageStatus>()
    val mStickArticles = MutableLiveData<List<Article>>()
    fun loadBanner() = launchUI {
        val result = withContext(Dispatchers.IO) { mainRepository.getBanners() }
        if (result is ResultData.Success) {
            mBanner.value = result.data
        }
    }

    fun loadHomeArticles(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            articleUserCase.getHomeArticleList(
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }

    fun loadStickArticles() = launchUI {
        val result = withContext(Dispatchers.IO) { mainRepository.getStickArticles() }
        if (result is ResultData.Success) {
            mStickArticles.value = result.data
        }
    }
}