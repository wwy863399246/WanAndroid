package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.HotWord
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.ArticleUserCase
import com.wwy.android.data.repository.SearchRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 下午 23:10
 *@描述
 */
class SearchViewModel(
    private var searchRepository: SearchRepository,
    private val articleUserCase: ArticleUserCase
) : BaseViewModel() {
    private val loadPageStatus = MutableLiveData<LoadPageStatus>()
    val mListModel = MutableLiveData<ListModel<Article>>()
    val saveState = MutableLiveData<Boolean>()
    var mHotWord = liveData<MutableList<HotWord>> {
        val hotWord = searchRepository.getHotWord()
        if (hotWord is ResultData.Success) {
            emit(hotWord.data)
        }
    }

    fun search(isRefresh: Boolean = false, key: String = "") = launchUI {
        withContext(Dispatchers.IO) {
            articleUserCase.getSearchArticleList(
                key,
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }

    fun saveSearchHistory(searchWords: String) {
        try {
            searchRepository.saveSearchHistory(searchWords)
            saveState.value = true
        } catch (e: Throwable) {
            saveState.value = false
        }

    }

    fun deleteSearchHistory(searchWords: String) {
        try {
            searchRepository.deleteSearchHistory(searchWords)
            saveState.value = true
        } catch (e: Throwable) {
            saveState.value = false
        }
    }

    fun getSearchHistory() = searchRepository.getSearchHistory()

}