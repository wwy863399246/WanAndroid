package com.wwy.android.data.repository

import com.wwy.android.data.bean.User
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.db.AppDatabase
import com.wwy.android.data.repository.datasource.RemoteDataSource
import com.wwy.android.ext.setLoginState

/**
 *@创建者wwy
 *@创建时间 2019/10/25 10:43
 *@描述
 */
class LoginRepository(private val remoteDataSource: RemoteDataSource) {
    private val userDao = AppDatabase.getInstance().userDao()
    suspend fun login(username: String, password: String): ResultData<User> {
        val result = remoteDataSource.login(username, password)
        if (result is ResultData.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    private fun setLoggedInUser(loggedInUser: User?) {
        userDao.deleteAll()
        userDao.insert(loggedInUser)
        setLoginState(true)
    }
}