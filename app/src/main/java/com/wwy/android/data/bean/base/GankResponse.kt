package com.wwy.android.data.bean.base

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:13
 *@描述
 */
data class GankResponse<out T>(var status: Int, val data: T)