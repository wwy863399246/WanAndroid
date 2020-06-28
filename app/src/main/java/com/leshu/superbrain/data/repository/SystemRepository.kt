package com.leshu.superbrain.data.repository

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.view.loadpage.LoadPageStatus

/**
 *@创建者wwy
 *@创建时间 2020/6/24 16:09
 *@描述
 */
class SystemRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getSystemType(listModel: MutableLiveData<ListModel<ClassifyResponse>>?) {
        val loadPageStatus = MutableLiveData<LoadPageStatus>()
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        val systemType = remoteDataSource.getSystemType()
        if (systemType is ResultData.Success) {//成功数据处理
            if (systemType.data.isNullOrEmpty()) {
                loadPageStatus.postValue(LoadPageStatus.Empty)
                listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
                return
            }
            listModel?.postValue(
                ListModel(
                    showSuccess = systemType.data
                )
            )
        } else if (systemType is ResultData.Error) {
            loadPageStatus.postValue(LoadPageStatus.Fail)
            listModel?.postValue(
                ListModel(
                    showError = systemType.exception.message,
                    loadPageStatus = loadPageStatus
                )
            )
        }
    }
}