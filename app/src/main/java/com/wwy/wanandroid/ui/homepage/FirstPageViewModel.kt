package com.wwy.wanandroid.ui.homepage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.wwy.wanandroid.MyApplication
import com.wwy.wanandroid.bean.Article
import com.wwy.wanandroid.bean.ArticleList
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.SystemParent
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.repository.HomeRepository
import com.wwy.wanandroid.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2019/10/9 9:51
 *@描述
 */
class FirstPageViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }
    val mArticleList: LiveData<PagedList<Article>> = MutableLiveData()
    val mBanner: MutableLiveData<List<Banner>> by lazy { MutableLiveData<List<Banner>>().also { loadBanner() } }

    fun getArticleList(page: Int) {
        launchUI({
            val result = withContext(Dispatchers.IO) { repository.getHomeArticles(page) }
           // mArticleList.value=result.value
        }, true)
    }

    private fun loadBanner() = launchUI({
        val result = withContext(Dispatchers.IO) { repository.getBanners() }
        if (result is ResultData.Success) {
            mBanner.value = result.data
        }
    }, true)

}