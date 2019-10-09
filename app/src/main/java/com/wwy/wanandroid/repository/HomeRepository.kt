package com.wwy.wanandroid.repository

import com.wwy.wanandroid.repository.base.BaseRepository
import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.HttpRepository
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.base.WanResponse
import kotlinx.coroutines.Deferred

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:13
 *@描述
 */
class HomeRepository : BaseRepository() {
    suspend fun getBanners(): Deferred<WanResponse<Banner>> {
        return apiCall { HttpRepository.getDefault(HostType.WAN_ANDROID).getBanner() }
    }


}