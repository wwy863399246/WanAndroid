package com.wwy.wanandroid.repository

import com.wwy.wanandroid.repository.base.BaseRepository
import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.RetrofitClient
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.SystemParent
import com.wwy.wanandroid.bean.base.WanResponse

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:13
 *@描述
 */
class HomeRepository : BaseRepository() {
    suspend fun getBanners(): WanResponse<List<Banner>> {
        return apiCall { RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.getBanner() }
    }

    suspend fun getSystemType(): WanResponse<List<SystemParent>> {
        return apiCall {
            RetrofitClient.RetrofitClient(HostType.WAN_ANDROID).service.getSystemType()
        }
    }


}