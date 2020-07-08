package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus

/**
 *@创建者wwy
 *@创建时间 2020/6/1 11:30
 *@描述
 */
class WeChatNumRepository(private val weChatNumRemoteDataSource: RemoteDataSource) {
    suspend fun getBlogType(listModel: MutableLiveData<ListModel<ClassifyResponse>>?) {
        val loadPageStatus = MutableLiveData<LoadPageStatus>()
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        val blogType = weChatNumRemoteDataSource.getBlogType()
        if (blogType is ResultData.Success) {//成功数据处理
            if (blogType.data.isNullOrEmpty()) {
                loadPageStatus.postValue(LoadPageStatus.Empty)
                listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
                return
            }
            listModel?.postValue(
                ListModel(
                    showSuccess = blogType.data
                )
            )
        } else if (blogType is ResultData.Error) {
            loadPageStatus.postValue(LoadPageStatus.Fail)
            listModel?.postValue(
                ListModel(
                    showError = blogType.exception.message,
                    loadPageStatus = loadPageStatus
                )
            )
        }
    }

}