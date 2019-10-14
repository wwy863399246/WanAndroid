package com.wwy.wanandroid.bean

import java.io.Serializable

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
data class SystemChild(val child: List<SystemChild>,
                       val courseId: Int,
                       val id: Int,
                       val name: String,
                       val order: Int,
                       val parentChapterId: Int,
                       val visible: Int):Serializable