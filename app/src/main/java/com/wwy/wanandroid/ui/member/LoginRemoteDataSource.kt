package com.wwy.wanandroid.ui.member

import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.RetrofitClient
import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.bean.base.WanResponse
import com.wwy.wanandroid.repository.base.BaseRemoteDataSource
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2019/10/25 15:53
 *@描述
 */
class LoginRemoteDataSource : BaseRemoteDataSource() {
    suspend fun login(username: String, password: String) = apiCall(
        call = { requestLogin(username, password) }
    )
    private suspend fun requestLogin(username: String, password: String): WanResponse<User> {
        var login = RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.login(username, password)

    }
}