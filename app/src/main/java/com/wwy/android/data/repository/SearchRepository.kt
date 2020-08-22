package com.wwy.android.data.repository

import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.ext.deleteSearchHistoryData
import com.wwy.android.ext.getSearchHistoryData
import com.wwy.android.ext.saveSearchHistoryData

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 下午 23:11
 *@描述
 */
class SearchRepository(private var remoteDataSource: RemoteDataSource) {
    suspend fun getHotWord() = remoteDataSource.getHotWord()
    fun saveSearchHistory(searchWords: String) {
        saveSearchHistoryData(searchWords)
    }


    fun deleteSearchHistory(searchWords: String) = deleteSearchHistoryData(searchWords)


    fun getSearchHistory() = getSearchHistoryData()
}