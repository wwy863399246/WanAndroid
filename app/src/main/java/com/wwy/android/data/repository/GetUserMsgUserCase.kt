package com.wwy.android.data.repository

import androidx.lifecycle.LiveData
import com.wwy.android.data.bean.User
import com.wwy.android.data.db.AppDatabase
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
     suspend fun isLogin(): Boolean {
        return userDao.loadUid() != 0
    }

    fun getUserMsg(): LiveData<User> {
        return userDao.loadUser()
    }
}