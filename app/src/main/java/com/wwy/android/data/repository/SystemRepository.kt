package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus

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