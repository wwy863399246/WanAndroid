package com.wwy.android.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.User
import com.wwy.android.data.db.AppDatabase
import com.wwy.android.util.ListModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect

/**
 *@创建者wwy
 *@创建时间 2020/8/7 0007 下午 16:35
 *@描述
 */
class GetUserMsgUserCase {
    private val userDao = AppDatabase.getInstance().userDao()
    fun isLogin(): LiveData<Int> {
        return userDao.loadUid()
    }

    fun getUserMsg(): LiveData<User> {
        return userDao.loadUser()
    }

    suspend fun clearUserMsg(listModel: MutableLiveData<ListModel<Int>>?) {
        listModel?.postValue(ListModel(showLoading = true))
        userDao.deleteAll()
        listModel?.postValue(ListModel(showLoading = false, showEnd = true))
    }
}