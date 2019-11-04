package com.wwy.wanandroid.db

import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wwy.wanandroid.bean.Article

/**
 *@创建者wwy
 *@创建时间 2019/11/4 11:07
 *@描述
 */
@Dao
interface ArticleDao {
    //插入所有
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(articles: List<Article>)

    @Query("SELECT * FROM Article")
    fun getArticleList(): DataSource.Factory<Int, Article>

    @Query("SELECT * FROM Article")
    fun loadAllProducts(): List<Article>

}