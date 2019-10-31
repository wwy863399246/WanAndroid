package com.wwy.wanandroid.ui.homepage

import androidx.lifecycle.MutableLiveData
import com.wwy.wanandroid.bean.ArticleList
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.SystemParent
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.repository.HomeRepository
import com.wwy.wanandroid.ui.base.BaseViewModel

/**
 *@创建者wwy
 *@创建时间 2019/10/9 9:51
 *@描述
 */
class FirstPageViewModel : BaseViewModel() {

    private val repository by lazy { HomeRepository() }
    val mArticleList: MutableLiveData<ArticleList> = MutableLiveData()
    val mBanner: MutableLiveData<List<Banner>> by lazy { MutableLiveData<List<Banner>>().also { loadBanner() } }

    fun getArticleList(page: Int) {
        launchUI({
            val result = repository.getHomeArticles(page)
            if (result is ResultData.Success) {
                mArticleList.value = result.data
            }
        }, true)
    }

    private fun loadBanner() = launchUI({
        val result = repository.getBanners()
        if (result is ResultData.Success) {
            mBanner.value = result.data
        }
    }, true)

}