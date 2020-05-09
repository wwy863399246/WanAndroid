package com.leshu.superbrain.data.db

import com.leshu.superbrain.app.MyApplication
import com.leshu.superbrain.data.bean.Article

/**
 *@创建者wwy
 *@创建时间 2019/11/4 13:49
 *@描述
 */
//@Database(entities = [Article::class], version = 1, exportSchema = false)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun articleDao(): ArticleDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getInstance(): AppDatabase =
//            INSTANCE ?: synchronized(this) {
//                INSTANCE ?: buildDatabase().also { INSTANCE = it }
//            }
//
//        private fun buildDatabase() =
//            Room.databaseBuilder(
//                MyApplication.CONTEXT,
//                AppDatabase::class.java, "user.db"
//            )
//                .build()
//    }
//}