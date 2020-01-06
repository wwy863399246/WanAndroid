package com.leshu.superbrain.repository

import com.leshu.superbrain.data.bean.User
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.repository.datasource.LoginRemoteDataSource
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/25 10:43
 *@描述
 */
class LoginRepository  {
    private val remoteDataSource by lazy { LoginRemoteDataSource() }
    suspend fun login(username: String, password: String): ResultData<User> {
        val result = remoteDataSource.login(username, password)

        if (result is ResultData.Success) {
            setLoggedInUser(result.data)
        }
        Timber.tag("wangwuyuan").d(result.toString())
        return result
    }
    private fun setLoggedInUser(loggedInUser: User) {
    }
}