package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import com.coder.zzq.smartshow.toast.SmartToast
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.util.ListModel

/**
 *@创建者wwy
 *@创建时间 2020/8/16 0016 下午 13:08
 *@描述
 */
class ShareRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun share(title: String, link: String, listModel: MutableLiveData<ListModel<Int>>?) {
        listModel?.postValue(ListModel(showLoading = true))
        val shareArticle = remoteDataSource.shareArticle(title, link)
        if (shareArticle is ResultData.Success) {
            listModel?.postValue(ListModel(showLoading = false, showEnd = true))
        } else if (shareArticle is ResultData.ErrorMessage) {
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showError = shareArticle.toString()
                )
            )
        }

    }

    suspend fun deleteShare(id: Int, listModel: MutableLiveData<ListModel<Int>>?) {
        listModel?.postValue(ListModel(showLoading = true))
        val deleteShare = remoteDataSource.deleteShare(id)
        if (deleteShare is ResultData.Success) {
            listModel?.postValue(ListModel(showLoading = false, showEnd = true))
        } else if (deleteShare is ResultData.ErrorMessage) {
            listModel?.postValue(ListModel(showLoading = false, showError = deleteShare.toString()))
        }
    }
}