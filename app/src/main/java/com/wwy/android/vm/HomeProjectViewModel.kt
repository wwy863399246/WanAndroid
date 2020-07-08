package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.data.repository.ArticleUserCase
import com.wwy.android.data.repository.ProjectRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2019/11/12 9:31
 *@描述
 */
class HomeProjectViewModel(
    private val projectRepository: ProjectRepository,
    private val articleUserCase: ArticleUserCase
) : BaseViewModel() {

    val mMainProjectListModel = MutableLiveData<ListModel<ClassifyResponse>>()
    val mProjectListModel = MutableLiveData<ListModel<Article>>()
    private val mProjectLoadPageStatus = MutableLiveData<LoadPageStatus>()
    fun loadProjectClassify() = launchUI {
        withContext(Dispatchers.IO) { projectRepository.getProjectClassify(mMainProjectListModel) }
    }

    fun loadProjectArticles(isRefresh: Boolean = false, cid: Int = 0) = launchUI {
        withContext(Dispatchers.IO) {
            when (cid) {
                0 -> {
                    articleUserCase.getLatestProjectList(
                        isRefresh,
                        mProjectListModel,
                        mProjectLoadPageStatus
                    )
                }
                else -> {
                    articleUserCase.getProjectTypeDetailList(
                        isRefresh,
                        mProjectListModel,
                        mProjectLoadPageStatus,
                        cid
                    )
                }
            }
        }
    }

}