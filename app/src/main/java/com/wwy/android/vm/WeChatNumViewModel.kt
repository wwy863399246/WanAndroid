package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.data.repository.ArticleUserCase
import com.wwy.android.data.repository.WeChatNumRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
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