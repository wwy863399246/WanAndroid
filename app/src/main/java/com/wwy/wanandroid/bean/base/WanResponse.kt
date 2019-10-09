package com.wwy.wanandroid.bean.base

/**
 * Created by wwy
 * on 2019/9/13 14:38
 */
data class WanResponse<out T>(val errorCode: Int, val errorMsg: String, val data: T)