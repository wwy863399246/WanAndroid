package com.wwy.android.data.bean

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
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
    @Ignore
    var tags: List<Tag> = emptyList(),
    var title: String? = "",
    var type: Int = 0,
    var userId: Int = 0,
    var visible: Int = 0,
    var zan: Int = 0,
    var top: Boolean = false
) : Parcelable

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
@Parcelize
data class ClassifyResponse(
    val children: List<Children>?,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
) : Parcelable

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

/**
 *积分数据
 */
data class PointRank(
    val coinCount: Int,
    val level: Int,
    val rank: Int,
    val userId: Int,
    val username: String
)

/**
 *签到积分
 */
data class PointRecord(
    val coinCount: Int,
    val date: Long,
    val desc: String,
    val id: Int,
    val reason: String,
    val type: Int,
    val userId: Int,
    val userName: String
)

/**
 *分享
 */
data class Shared(
    val coinInfo: PointRank,
    val shareArticles: WanListResponse<MutableList<Article>>
)


data class MeiZi(
    var _id: String,// 5e959250808d6d2fe6b56eda
    var author: String,// 鸢媛
    var category: String,// Girl
    var createdAt: String,// 2020-05-25 08:00:00
    var desc: String,// 与其安慰自己平凡可贵， 不如拼尽全力活得漂亮。 ​ ​​​​
    var images: List<String>?,
    var likeCounts: Int,// 3
    var publishedAt: String,// 2020-05-25 08:00:00
    var stars: Int,// 1
    var title: String,// 第96期
    var type: String,// Girl
    var url: String,// http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2
    var views: Int// 5705
)

data class ReadHistory(
    @Embedded
    var article: Article,
    @Relation(parentColumn = "id", entityColumn = "article_id")
    var tags: List<Tag>
)

@Parcelize
@Entity
data class Tag(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "article_id")
    var articleId: Long,
    var name: String?,
    var url: String?
) : Parcelable

data class HotWord(
    val id: Int,
    val link: String,
    val order: Int,
    val name: String,
    val visible: Int
)
