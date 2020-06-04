package com.leshu.superbrain.vm

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.repository.ArticleUserCase
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus
import com.leshu.superbrain.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/6/1 11:29
 *@描述
 */
class HomePlazaViewModel(private val articleUserCase: ArticleUserCase) : BaseViewModel() {
    val mHomePlazaListModel = MutableLiveData<ListModel<Article>>()
    private val plazaLoadPageStatus = MutableLiveData<LoadPageStatus>()

    fun loadSquareArticleList(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            articleUserCase.getSquareArticleList(isRefresh, mHomePlazaListModel, plazaLoadPageStatus)
        }
    }
}