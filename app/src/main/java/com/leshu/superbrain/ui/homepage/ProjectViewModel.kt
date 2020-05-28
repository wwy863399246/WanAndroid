package com.leshu.superbrain.ui.homepage

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.ProjectRepository
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2019/11/12 9:31
 *@描述
 */
class ProjectViewModel : BaseViewModel() {
    private val projectRepository by lazy { ProjectRepository() }
    val mListModel = MutableLiveData<ListModel<ClassifyResponse>>()
    fun loadProjectClassify() = launchUI {
        withContext(Dispatchers.IO) { projectRepository.getProjectClassify(mListModel) }
    }

}