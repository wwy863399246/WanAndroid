package com.wwy.android.data.db

import androidx.room.*
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.ReadHistory
import com.wwy.android.data.bean.Tag
import kotlinx.coroutines.flow.Flow

/**
 *@创建者wwy
 *@创建时间 2020/8/20 0020 下午 22:16
 *@描述
 */
@Dao
interface ReadHistoryDao {
    @Transaction
    @Insert(entity = Article::class)
    suspend fun insert(article: Article): Long

    @Transaction
    @Insert(entity = Tag::class)
    suspend fun insertArticleTag(tag: Tag): Long

    @Transaction
    @Query("SELECT * FROM article")
    fun queryAll(): Flow<List<ReadHistory>>

    @Transaction
    @Query("SELECT * FROM article")
    fun queryAllNoFlow(): List<ReadHistory>

    @Transaction
    @Query("SELECT * FROM article WHERE id = (:id)")
    suspend fun queryArticle(id: Int): Article?

    @Transaction
    @Delete(entity = Article::class)
    suspend fun deleteArticle(article: Article)

    @Transaction
    @Update(entity = Article::class)
    suspend fun updateArticle(article: Article)
}