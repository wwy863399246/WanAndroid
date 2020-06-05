package com.leshu.superbrain.vm

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.repository.ArticleUserCase
import com.leshu.superbrain.data.repository.WeChatNumRepository
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus
import com.leshu.superbrain.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/6/4 19:33
 *@描述
 */
class WeChatNumViewModel(
    private val weChatNumRepository: WeChatNumRepository,
    private val articleUserCase: ArticleUserCase
) : BaseViewModel() {
    val mBlogTypeListModel = MutableLiveData<ListModel<ClassifyResponse>>()
    val mBlogDataByTypeModel = MutableLiveData<ListModel<Article>>()
    private val mBlogDataByTypeLoadPageStatus = MutableLiveData<LoadPageStatus>()
    fun loadBlogType() = launchUI {
        withContext(Dispatchers.IO) {
            weChatNumRepository.getBlogType(mBlogTypeListModel)
        }
    }

    fun loadBlogDataByType(isRefresh: Boolean = false, id: Int) = launchUI {
        withContext(Dispatchers.IO) {
            articleUserCase.getBlogArticleList(isRefresh,mBlogDataByTypeModel,mBlogDataByTypeLoadPageStatus,id)
        }
    }

}