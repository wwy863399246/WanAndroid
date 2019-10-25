package com.wwy.wanandroid.bean


/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
data class User(val collectIds: List<Int>,
                val email: String,
                val icon: String,
                val id: Int,
                val password: String,
                val type: Int,
                val username: String)