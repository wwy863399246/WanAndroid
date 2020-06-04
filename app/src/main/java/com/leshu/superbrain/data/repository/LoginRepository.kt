package com.leshu.superbrain.data.repository

import com.leshu.superbrain.data.bean.User
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.datasource.RemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2019/10/25 10:43
 *@描述
 */
class LoginRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun login(username: String, password: String): ResultData<User> {
        val result = remoteDataSource.login(username, password)

        if (result is ResultData.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    private fun setLoggedInUser(loggedInUser: User) {
    }
}