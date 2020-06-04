package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus

class ProjectRepository(private val projectRemoteDataSource: RemoteDataSource) {
    suspend fun getProjectClassify(listModel: MutableLiveData<ListModel<ClassifyResponse>>?) {
        val loadPageStatus = MutableLiveData<LoadPageStatus>()
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        val projectClassify = projectRemoteDataSource.getProjectClassify()
        if (projectClassify is ResultData.Success) {//成功数据处理
            if (projectClassify.data.isNullOrEmpty()) {
                loadPageStatus.postValue(LoadPageStatus.Empty)
                listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
            }
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showSuccess = projectClassify.data
                )
            )
        } else if (projectClassify is ResultData.Error) {
            loadPageStatus.postValue(LoadPageStatus.Fail)
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showError = projectClassify.exception.message,
                    loadPageStatus = loadPageStatus
                )
            )
        }
    }
}
