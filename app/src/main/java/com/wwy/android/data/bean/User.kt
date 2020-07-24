package com.wwy.android.data.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
@Entity
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val id: Int,
    val collectIds: List<Int>,
    val type: Int,
    @ColumnInfo(name = "user_icon")
    var icon: String?,
    @ColumnInfo(name = "user_public_name")
    var publicName: String?,
    @ColumnInfo(name = "user_name")
    val username: String?
)