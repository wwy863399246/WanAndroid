package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.MeiZi
import com.wwy.android.data.bean.PointRecord
import com.wwy.android.data.repository.KuTuRepository
import com.wwy.android.util.ListModel
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/8/19 0019 下午 22:26
 *@描述
 */
class KuTuViewModel(private val kuTuRepository: KuTuRepository) : BaseViewModel() {
    private val loadPageStatus = MutableLiveData<LoadPageStatus>()
    val mListModel = MutableLiveData<ListModel<MeiZi>>()
    fun getMeiZi(isRefresh: Boolean = false) = launchUI {
        withContext(Dispatchers.IO) {
            kuTuRepository.getMeiZi(
                isRefresh,
                mListModel,
                loadPageStatus
            )
        }
    }
}