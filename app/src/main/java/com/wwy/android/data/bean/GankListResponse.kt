package com.wwy.android.data.bean

import java.io.Serializable

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
data class GankListResponse<T>(val page: Int,
                               val status: Int,
                               val pageCount: Int,
                               val total_counts: Int,
                               val datas: T):Serializable