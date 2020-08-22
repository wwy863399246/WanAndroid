package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.data.repository.ArticleUserCase
import com.wwy.android.data.repository.SystemRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/6/24 16:35
 *@描述
 */
class SystemViewModel(
    private val repository: SystemRepository,
    private val userCase: ArticleUserCase
) : BaseViewModel() {
    val systemClassifyListModel = MutableLiveData<ListModel<ClassifyResponse>>()
    val mSystemListModel = MutableLiveData<ListModel<Article>>()
    private val mSystemLoadPageStatus = MutableLiveData<LoadPageStatus>()
    fun getSystemType() = launchUI {
        withContext(Dispatchers.IO) { repository.getSystemType(systemClassifyListModel) }
    }

    fun loadSystemArticles(isRefresh: Boolean = false, cid: Int) = launchUI {
        withContext(Dispatchers.IO) {
            userCase.getSystemTypeArticleList(
                isRefresh,
                mSystemListModel,
                mSystemLoadPageStatus,
                cid
            )
        }
    }
}