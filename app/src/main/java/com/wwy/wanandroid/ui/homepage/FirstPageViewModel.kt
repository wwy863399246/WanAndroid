package com.wwy.wanandroid.ui.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.wwy.wanandroid.bean.Article
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.repository.HomeRepository
import com.wwy.wanandroid.ui.base.BaseViewModel
import com.wwy.wanandroid.util.ListingModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2019/10/9 9:51
 *@描述
 */
class FirstPageViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }
    private val listingModel = MutableLiveData<ListingModel<Article>>()
    val mBanner: MutableLiveData<List<Banner>> by lazy { MutableLiveData<List<Banner>>().also { loadBanner() } }
    val pagedList = Transformations.switchMap(listingModel) {
        it.pagedList
    }
    val listStatus = Transformations.switchMap(listingModel) {
        it.listStatus
    }
    val refreshStatus = Transformations.switchMap(listingModel) {
        it.refreshStatus
    }


    fun getArticleList(page: Int, isNeedRefreshStatus: Boolean) {
        launchUI({
            //val result: LiveData<PagedList<Article>> = withContext(Dispatchers.IO) { repository.getHomeArticles(page) }
            val articles = withContext(Dispatchers.IO) { repository.homeArticles(page, isNeedRefreshStatus) }
            listingModel.value = articles
        }, true)
    }


    private fun loadBanner() = launchUI({
        val result = withContext(Dispatchers.IO) { repository.getBanners() }
        if (result is ResultData.Success) {
            mBanner.value = result.data
        }
    }, false)

}