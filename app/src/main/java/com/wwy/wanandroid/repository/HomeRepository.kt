package com.wwy.wanandroid.repository

import androidx.lifecycle.LiveData
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.wwy.wanandroid.repository.base.BaseRepository
import com.wwy.wanandroid.api.HostType
import com.wwy.wanandroid.api.RetrofitClient
import com.wwy.wanandroid.bean.Article
import com.wwy.wanandroid.bean.ArticleList
import com.wwy.wanandroid.bean.Banner
import com.wwy.wanandroid.bean.SystemParent
import com.wwy.wanandroid.bean.base.ResultData
import com.wwy.wanandroid.bean.base.WanResponse
import com.wwy.wanandroid.repository.datasource.HomeRemoteDataSource
import com.wwy.wanandroid.ui.member.LoginRemoteDataSource

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:13
 *@描述
 */
class HomeRepository {
    private val remoteDataSource by lazy { HomeRemoteDataSource() }
    suspend fun getHomeArticles(page: Int): ResultData<ArticleList> {
        val homeArticlesData = remoteDataSource.getHomeArticles(page)
        if (homeArticlesData is ResultData.Success) {//在这里存存本地数据库
            var datas : List<Article> = homeArticlesData.data.datas

            return homeArticlesData
        }
        return homeArticlesData
    }


    suspend fun getBanners(): ResultData<List<Banner>> {
        val banerData = remoteDataSource.getBanners()
        if (banerData is ResultData.Success) {//在这里存存本地数据库
            return banerData
        }
        return banerData
    }
}