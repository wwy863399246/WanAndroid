package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.ReadHistoryUserCase
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 上午 0:22
 *@描述
 */
class ReadHistoryViewMode(private val readHistoryUserCase: ReadHistoryUserCase) : BaseViewModel() {
    val mReadHistoryListModel = MutableLiveData<ListModel<Article>>()
    private val mReadHistoryLoadPageStatus = MutableLiveData<LoadPageStatus>()
    val mDeleteReadHistoryState = MutableLiveData<ListModel<Int>>()
    fun queryAllReadHistory() {
        launchUI {
            withContext(Dispatchers.IO) {
                readHistoryUserCase.queryAllReadHistory(
                    mReadHistoryListModel,
                    mReadHistoryLoadPageStatus
                )
            }
        }
    }

    fun deleteReadHistory(article: Article) = launchUI {
        withContext(Dispatchers.IO) {
            readHistoryUserCase.deleteReadHistory(article, mDeleteReadHistoryState)
        }
    }
}