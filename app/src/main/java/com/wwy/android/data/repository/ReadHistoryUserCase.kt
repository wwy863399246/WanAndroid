package com.wwy.android.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.ReadHistory
import com.wwy.android.data.bean.Tag
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.db.AppDatabase
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import kotlinx.coroutines.flow.*

/**
 *@创建者wwy
 *@创建时间 2020/8/20 0020 下午 20:16
 *@描述
 */
class ReadHistoryUserCase {
    private val readHistoryDao by lazy { AppDatabase.getInstance().readHistoryDao() }
    fun queryAllReadHistory(): Flow<List<Article>> = readHistoryDao.queryAll().map {
        reversedAllReadHistory(it)
    }

    private fun reversedAllReadHistory(list: List<ReadHistory>): List<Article> =
        list.map { it.article.apply { tags = it.tags } }.reversed()


    suspend fun addReadHistory(article: Article) {
        readHistoryDao.queryArticle(article.id)?.let {
            readHistoryDao.deleteArticle(it)
        }
        readHistoryDao.insert(article.apply { primaryKeyId = 0 })
        article.tags.forEach {
            readHistoryDao.insertArticleTag(
                Tag(id = 0, articleId = article.id.toLong(), name = it.name, url = it.url)
            )
        }
    }

    fun queryAllReadHistory(
        listModel: MutableLiveData<ListModel<Article>>?,
        loadPageStatus: MutableLiveData<LoadPageStatus>
    ) {
        loadPageStatus.postValue(LoadPageStatus.Loading)
        listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
        try {
            val list = readHistoryDao.queryAllNoFlow().map {
                it.article.apply { tags = it.tags }
            }.reversed()
            if (list.isNullOrEmpty()) {
                loadPageStatus.postValue(LoadPageStatus.Empty)
                listModel?.postValue(ListModel(loadPageStatus = loadPageStatus))
            } else {
                listModel?.postValue(
                    ListModel(
                        showLoading = false,
                        showSuccess = list
                    )
                )
            }
        } catch (e: Throwable) {
            loadPageStatus.postValue(LoadPageStatus.Fail)
            listModel?.postValue(
                ListModel(
                    showLoading = false,
                    showError = e.message,
                    loadPageStatus = loadPageStatus
                )
            )
        }

    }

    suspend fun deleteReadHistory(article: Article, listModel: MutableLiveData<ListModel<Int>>?) {
        listModel?.postValue(ListModel(showLoading = true))
        try {
            readHistoryDao.deleteArticle(article)
            listModel?.postValue(ListModel(showLoading = false, showEnd = true))
        } catch (e: Throwable) {
            listModel?.postValue(ListModel(showLoading = false, showError = e.toString()))
        }
    }
}