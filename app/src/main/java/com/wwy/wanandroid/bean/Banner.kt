package com.wwy.wanandroid.bean

import androidx.room.Entity

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
data class Banner(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)