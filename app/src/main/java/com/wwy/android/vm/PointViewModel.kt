package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.PointRank
import com.wwy.android.data.bean.PointRecord
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.PointRepository
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
class PointViewModel(private val pointRepository: PointRepository) : BaseViewModel() {
    private val loadPageStatus = MutableLiveData<LoadPageStatus>()
    val mListModel = MutableLiveData<ListModel<PointRecord>>()
    val mPointLiveData = liveData<PointRank> {
        val points = pointRepository.getPoints()
        if (points is ResultData.Success) {
            emit(points.data)
        }
    }
    fun getPointsRecord(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            pointRepository.getPointsRecord(
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }
}