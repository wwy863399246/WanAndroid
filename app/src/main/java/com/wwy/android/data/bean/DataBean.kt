package com.wwy.android.data.bean

import java.io.Serializable

data class Article(
    val id: Int,
    val originId: Int,
    val title: String,
    val chapterId: Int,
    val chapterName: String,
    val envelopePic: String,
    val link: String,
    val author: String,
    val origin: String,
    val publishTime: Long,
    val zan: Int,
    val desc: String,
    val visible: Int,
    val niceDate: String,
    val niceShareDate: String,
    val courseId: Int,
    var collect: Boolean,
    val apkLink: String,
    val projectLink: String,
    val superChapterId: Int,
    val superChapterName: String?,
    val type: Int,
    val fresh: Boolean,
    val audit: Int,
    val prefix: String,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
    val tags: Any, // Not sure
    val userId: Int
) : Serializable

/**
 * Banner
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
) : Serializable

/**
 * 项目分类
 */
data class ClassifyResponse(
    val children: List<Children>?,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
) : Serializable

data class Children(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
) : Serializable

/**
 *导航数据
 */
data class Navigation(
    val articles: List<Article>,
    val cid: Int,
    val name: String
)
/**
 *我的页面功能
 */
data class MyFunction(
    val drawable: Int,
    val functionName: String
)

/**
 *主题数据
 */
data class Theme(
    val color: Int,
    val theme: Int,
    val colorName: String,
    var isChoose: Int
)
