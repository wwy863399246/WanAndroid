package com.wwy.android.data.bean

import android.os.Parcelable
import androidx.room.Ignore
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class Article(
    var primaryKeyId: Int = 0,
    var apkLink: String? = "",
    var audit: Int = 0,
    var author: String? = "",
    var chapterId: Int = 0,
    var chapterName: String? = "",
    var collect: Boolean = false,
    var courseId: Int = 0,
    var desc: String? = "",
    var envelopePic: String? = "",
    var fresh: Boolean = false,
    var id: Int = 0,
    var link: String? = "",
    var niceDate: String? = "",
    var niceShareDate: String? = "",
    var origin: String? = "",
    var originId: Int = 0,
    var prefix: String? = "",
    var projectLink: String? = "",
    var publishTime: Long = 0,
    var selfVisible: Int = 0,
    var shareDate: Long = 0,
    var shareUser: String? = "",
    var superChapterId: Int = 0,
    var superChapterName: String? = "",
//    @Ignore
//    var tags: List<Tag> = emptyList(),
    var title: String? = "",
    var type: Int = 0,
    var userId: Int = 0,
    var visible: Int = 0,
    var zan: Int = 0,
    var top: Boolean = false
) :  Parcelable

/**
 * Banner
 */

class Banner(
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
