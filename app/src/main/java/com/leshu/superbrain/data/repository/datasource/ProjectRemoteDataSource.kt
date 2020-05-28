package com.leshu.superbrain.data.repository.datasource

import com.leshu.superbrain.data.api.RetrofitClient
import com.leshu.superbrain.data.api.WAN_ANDROID
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.User
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

    private suspend fun requestProjectClassify(): ResultData<List<ClassifyResponse>> {
        val projectClassify = RetrofitClient(WAN_ANDROID).service.getProjectTypes()
        if (projectClassify.errorCode == 0) {
            return ResultData.Success(projectClassify.data)
        }
        return ResultData.Error(IOException("Failed to get login${projectClassify.errorMsg}"))
    }
}