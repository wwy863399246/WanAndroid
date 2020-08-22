package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.ArticleUserCase
import com.wwy.android.data.repository.GetUserMsgUserCase
import com.wwy.android.data.repository.ShareRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/8/15 0015 下午 21:21
 *@描述
 */
class MyCollectAndShareViewModel(
    private val articleUserCase: ArticleUserCase,
    private val shareRepository: ShareRepository,
    userMsgUserCase: GetUserMsgUserCase

) : BaseViewModel() {
    private val loadPageStatus = MutableLiveData<LoadPageStatus>()
    val mListModel = MutableLiveData<ListModel<Article>>()
    val mShareStatus = MutableLiveData<ListModel<Int>>()
    fun getCollectList(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            articleUserCase.getCollectArticleList(
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }

    fun getShareList(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            articleUserCase.getShareArticleList(
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }

    fun share(title: String, link: String) = launchUI {
        withContext(Dispatchers.IO) {
            shareRepository.share(title, link, mShareStatus)
        }
    }

    fun deleteShare(id: Int) = launchUI {
        withContext(Dispatchers.IO) {
            shareRepository.deleteShare(id, mShareStatus)
        }
    }

    var userLiveData = userMsgUserCase.getUserMsg()

}