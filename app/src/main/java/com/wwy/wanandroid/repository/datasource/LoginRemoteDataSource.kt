package com.wwy.wanandroid.ui.member

import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.RetrofitClient
import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.util.safeApiCall
import java.io.IOException

/**
 *@创建者wwy
 *@创建时间 2019/10/25 15:53
 *@描述 登录远程数据类
 */
class LoginRemoteDataSource {
    suspend fun login(username: String, password: String) = safeApiCall(
        call = { requestLogin(username, password) }
    )

    private suspend fun requestLogin(username: String, password: String): ResultData<User> {
        val login = RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.login(username, password)
        if (login.errorCode == 0) {
            return ResultData.Success(login.data)
        }
        return ResultData.Error(IOException("Failed to get login${login.errorMsg}"))
    }
}