package com.wwy.wanandroid.repository

import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.RetrofitClient
import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.bean.base.WanResponse
import com.wwy.wanandroid.repository.base.BaseRepository

/**
 *@创建者wwy
 *@创建时间 2019/10/25 10:43
 *@描述
 */
class LoginRepository : BaseRepository() {
    suspend fun login(userName: String, passWord: String): WanResponse<User> {
        return apiCall { RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.login(userName, passWord) }
    }
}