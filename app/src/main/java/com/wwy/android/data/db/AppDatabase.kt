package com.wwy.android.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wwy.android.app.MyApplication
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.Tag
import com.wwy.android.data.bean.User

/**
 *@创建者wwy
 *@创建时间 2019/11/4 13:49
 *@描述
 */
@Database(entities = [User::class, Article::class, Tag::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun readHistoryDao(): ReadHistoryDao

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
                AppDatabase::class.java, "user.db"
            )
                .build()
    }
}