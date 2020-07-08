package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus

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
