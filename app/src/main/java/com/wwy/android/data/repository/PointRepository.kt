package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.PointRecord
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import java.net.UnknownHostException

/**
 *@创建者wwy
 *@创建时间 2020/8/17 0017 下午 20:27
 *@描述
 */
class PointRepository(private val remoteDataSource: RemoteDataSource) {
    private var currentPage = 0
    suspend fun getPoints() = remoteDataSource.getPoints()

    suspend fun getPointsRecord(
        isRefresh: Boolean = false,
        listModel: MutableLiveData<ListModel<PointRecord>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) {
        if (isRefresh){
            currentPage = 0
            loadPageStatus.postValue(LoadPageStatus.Loading)
            listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        }
        val result = remoteDataSource.getPointsRecord(currentPage)
        if (result is ResultData.Success) {
            val data = result.data
            if (data.datas.isNullOrEmpty() && currentPage == 0) {//开始加载无数据
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
            if (data.offset >= data.total) {//最后一页  showLoading 可以用来加载dialog
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
                    showSuccess = data.datas,
                    isRefresh = isRefresh
                )
            )
        } else if (result is ResultData.Error) {
            if (result.exception is UnknownHostException) {//加载失败 这里可以区分失败原因，设置不同页面状态
                if (currentPage == 0) loadPageStatus.postValue(LoadPageStatus.NoNet)
            } else {
                if (currentPage == 0) loadPageStatus.postValue(LoadPageStatus.Fail)
            }
            listModel?.postValue(
                ListModel(
                    isRefreshSuccess = false,
                    showError = result.exception.message,
                    loadPageStatus = loadPageStatus,
                    isRefresh = isRefresh
                )
            )
        }
    }
}