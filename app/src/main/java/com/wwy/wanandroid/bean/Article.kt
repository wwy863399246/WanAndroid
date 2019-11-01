package com.wwy.wanandroid.bean

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 *@创建者wwy
 *@创建时间 2019/10/8 11:26
 *@描述
 */
data class Article(
    val key: Long,
    val id: Int,
    val author: String,
    var shareUser: String,
    val title: String,
    val chapterName: String,
    val superChapterName: String?,
    val niceDate: String,
    val originId: Int,
    val chapterId: Int,
    val envelopePic: String,
    val link: String,
    val origin: String,
    val publishTime: Long,
    val zan: Int,
    val desc: String,
    val visible: Int,
    val courseId: Int,
    var collect: Boolean,
    val apkLink: String,
    val projectLink: String,
    val superChapterId: Int,
    val type: Int,
    val fresh: Boolean
) : Serializable