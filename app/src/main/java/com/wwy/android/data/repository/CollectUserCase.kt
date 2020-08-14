package com.wwy.android.data.repository

import com.wwy.android.data.repository.datasource.RemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2020/8/10 0010 下午 18:36
 *@描述
 */
class CollectUserCase(private val remoteDataSource: RemoteDataSource) {
    suspend fun collect(id: Int) =remoteDataSource.collect(id)
    suspend fun unCollect(id: Int) = remoteDataSource.unCollect(id)
}