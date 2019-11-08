package com.wwy.wanandroid.repository

import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.repository.datasource.LoginRemoteDataSource

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
        return result
    }
    private fun setLoggedInUser(loggedInUser: User) {
    }
}