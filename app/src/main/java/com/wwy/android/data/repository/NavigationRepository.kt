package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Navigation
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus

/**
 *@创建者wwy
 *@创建时间 2020/6/24 16:09
 *@描述
 */
class NavigationRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getNavigationData(listModel: MutableLiveData<ListModel<Navigation>>?) {
        val loadPageStatus = MutableLiveData<LoadPageStatus>()
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        val navigationData = remoteDataSource.getNavigationData()
        if (navigationData is ResultData.Success) {//成功数据处理
            if (navigationData.data.isNullOrEmpty()) {
                loadPageStatus.postValue(LoadPageStatus.Empty)
                listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
                return
            }
            listModel?.postValue(
                ListModel(
                    showSuccess = navigationData.data
                )
            )
        } else if (navigationData is ResultData.Error) {
            loadPageStatus.postValue(LoadPageStatus.Fail)
            listModel?.postValue(
                ListModel(
                    showError = navigationData.exception.message,
                    loadPageStatus = loadPageStatus
                )
            )
        }
    }
}