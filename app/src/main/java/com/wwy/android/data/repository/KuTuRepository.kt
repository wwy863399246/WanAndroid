package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.MeiZi
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus

/**
 *@创建者wwy
 *@创建时间 2020/8/19 0019 下午 22:02
 *@描述
 */
class KuTuRepository(private val remoteDataSource: RemoteDataSource) {
    private var currentPage = 1
    suspend fun getMeiZi(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<MeiZi>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) {
        if (isRefresh) {
            currentPage = 1
            loadPageStatus.postValue(LoadPageStatus.Loading)
            listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        }
        val meiZi = remoteDataSource.getMeiZi(currentPage)
        if (meiZi is ResultData.Success) {
            val data = meiZi.data
            if (data.isNullOrEmpty() && currentPage == 1) {//开始加载无数据
                loadPageStatus.postValue(LoadPageStatus.Empty) //显示空界面
                listModel?.postValue(
                    ListModel(
                        isRefreshSuccess = false,
                        loadPageStatus = loadPageStatus,
                        isRefresh = isRefresh
                    )
                )
                return
            }
            if (data.size < 10) {
                listModel?.postValue(
                    ListModel(
                        isRefreshSuccess = true,
                        showEnd = true,
                        isRefresh = isRefresh
                    )
                )
                return
            }
            currentPage++
            listModel?.postValue(
                ListModel(
                    isRefreshSuccess = true,
                    showSuccess = data,
                    isRefresh = isRefresh
                )
            )
        } else if (meiZi is ResultData.ErrorMessage) {
            listModel?.postValue(
                ListModel(
                    isRefreshSuccess = false,
                    showError = meiZi.message,
                    loadPageStatus = loadPageStatus,
                    isRefresh = isRefresh
                )
            )
        }
    }
}