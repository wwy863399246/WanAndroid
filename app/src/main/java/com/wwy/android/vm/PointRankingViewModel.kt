package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.PointRank
import com.wwy.android.data.repository.PointRankRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/8/17 0017 下午 21:19
 *@描述
 */
class PointRankingViewModel(private val pointRepository: PointRankRepository) : BaseViewModel() {
    private val loadPageStatus = MutableLiveData<LoadPageStatus>()
    val mListModel = MutableLiveData<ListModel<PointRank>>()
    fun getPointsRank(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            pointRepository.getPointsRank(
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }
}