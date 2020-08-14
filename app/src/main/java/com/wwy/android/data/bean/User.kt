package com.wwy.android.data.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable


/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
@Entity
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val id: Int = 0,
    @ColumnInfo(name = "user_icon")
    var icon: String? = null,
    @ColumnInfo(name = "user_public_name")
    var publicName: String? = null,
    @ColumnInfo(name = "user_name")
    val username: String? = null
) : Serializable