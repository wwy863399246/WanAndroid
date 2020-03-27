package com.leshu.superbrain.ui.homepage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.HomeRepository
import com.leshu.superbrain.vm.base.BaseViewModel
import com.leshu.superbrain.util.ListingModel
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
    val mBannerResponse: MutableLiveData<List<BannerResponse>> by lazy { MutableLiveData<List<BannerResponse>>().also { loadBanner() } }
    val pagedList = Transformations.switchMap(listingModel) {
        it.pagedList
    }
    val listStatus = Transformations.switchMap(listingModel) {
        it.listStatus
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
            mBannerResponse.value = result.data
        }
    }, false)

}