package com.wwy.android.data.bean

import java.io.Serializable

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
data class WanListResponse<T>(val offset: Int,
                           val size: Int,
                           val total: Int,
                           val pageCount: Int,
                           val curPage: Int,
                           val over: Boolean,
                           val datas: T):Serializable