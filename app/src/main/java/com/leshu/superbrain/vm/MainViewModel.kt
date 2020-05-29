package com.leshu.superbrain.vm

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.Banner
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.ArticleUserCase
import com.leshu.superbrain.data.repository.MainRepository
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus
import com.leshu.superbrain.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/1/13 14:24
 *@描述
 */
class MainViewModel : BaseViewModel() {
    private val mainRepository by lazy { MainRepository() }
    private val articleUserCase by lazy { ArticleUserCase() }
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