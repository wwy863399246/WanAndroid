package com.leshu.superbrain.data.repository

import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2020/6/24 16:09
 *@描述
 */
class SystemRepository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getSystemType(): ResultData<List<ClassifyResponse>> {
        return remoteDataSource.getSystemType()
    }
}