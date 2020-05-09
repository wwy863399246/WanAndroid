package com.leshu.superbrain.vm

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.Banner
import com.leshu.superbrain.data.bean.BannerResponse
import com.leshu.superbrain.data.bean.User
import com.leshu.superbrain.data.bean.base.ResultData
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
    val mBanner: MutableLiveData<List<Banner>> = MutableLiveData()
    val mLoadPageStatus: MutableLiveData<LoadPageStatus> = MutableLiveData()
    val mListModel = MutableLiveData<ListModel<Article>>()
    fun loadBanner() = launchUI {
        val result = withContext(Dispatchers.IO) { mainRepository.getBanners() }
        if (result is ResultData.Success) {
            mBanner.value = result.data
        }
    }

    fun loadHomeArticles(isRefresh: Boolean = false) = launchUI {
         withContext(Dispatchers.IO) { mainRepository.getHomeArticles(isRefresh,mListModel) }
    }
}