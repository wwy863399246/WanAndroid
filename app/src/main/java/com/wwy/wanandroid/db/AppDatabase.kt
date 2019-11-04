package com.wwy.wanandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wwy.wanandroid.MyApplication
import com.wwy.wanandroid.bean.Article
import com.wwy.wanandroid.util.DATABASE_NAME

/**
 *@创建者wwy
 *@创建时间 2019/11/4 13:49
 *@描述
 */
@Database(entities = [Article::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase().also { INSTANCE = it }
            }

        private fun buildDatabase() =
            Room.databaseBuilder(
                MyApplication.CONTEXT,
                AppDatabase::class.java, DATABASE_NAME
            )
                .build()
    }
}