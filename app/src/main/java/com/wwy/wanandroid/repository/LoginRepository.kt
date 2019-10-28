package com.wwy.wanandroid.repository

import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.bean.base.Result
import com.wwy.wanandroid.ui.member.LoginRemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2019/10/25 10:43
 *@描述
 */
class LoginRepository (private val remoteDataSource: LoginRemoteDataSource
) {
    suspend fun login(username: String, password: String): Result<User> {
        val result = remoteDataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }
    private fun setLoggedInUser(loggedInUser: User) {
    }
}