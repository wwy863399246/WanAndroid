package com.leshu.superbrain.data.repository.datasource

import com.leshu.superbrain.data.api.RetrofitClient
import com.leshu.superbrain.data.api.WAN_ANDROID
import com.leshu.superbrain.data.bean.Article
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.User
import com.leshu.superbrain.data.bean.WanListResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.util.safeApiCall
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2019/11/12 9:52
 *@描述
 */
class ProjectRemoteDataSource {

    suspend fun getProjectClassify() = safeApiCall(
        call = { requestProjectClassify() }
    )

    suspend fun getLatestProjectList(page: Int) = safeApiCall(
        call = { requestLatestProjectList(page) }
    )

    suspend fun getProjectTypeDetailList(page: Int, cid: Int) = safeApiCall(
        call = { requestProjectTypeDetailList(page, cid) }
    )

    private suspend fun requestProjectClassify(): ResultData<List<ClassifyResponse>> {
        val projectClassify = RetrofitClient(WAN_ANDROID).service.getProjectTypes()
        if (projectClassify.errorCode == 0) {
            return ResultData.Success(projectClassify.data)
        }
        return ResultData.Error(IOException("Failed to get login${projectClassify.errorMsg}"))
    }

    private suspend fun requestLatestProjectList(page: Int): ResultData<WanListResponse<List<Article>>> {
        val projectNewData = RetrofitClient(WAN_ANDROID).service.getProjecNewData(page)
        if (projectNewData.errorCode == 0) {
            return ResultData.Success(projectNewData.data)
        }
        return ResultData.Error(IOException("Failed to get login${projectNewData.errorMsg}"))
    }

    private suspend fun requestProjectTypeDetailList(
        page: Int,
        cid: Int
    ): ResultData<WanListResponse<List<Article>>> {
        val projectDataByType = RetrofitClient(WAN_ANDROID).service.getProjectDataByType(page, cid)
        if (projectDataByType.errorCode == 0) {
            return ResultData.Success(projectDataByType.data)
        }
        return ResultData.Error(IOException("Failed to get login${projectDataByType.errorMsg}"))
    }
}