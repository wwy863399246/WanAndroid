package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.Navigation
import com.wwy.android.data.repository.NavigationRepository
import com.wwy.android.util.ListModel
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/6/24 16:35
 *@描述
 */
class NavigationViewModel(
    private val repository: NavigationRepository
) : BaseViewModel() {
    val navigationListModel = MutableLiveData<ListModel<Navigation>>()
    fun getNavigationData() = launchUI {
        withContext(Dispatchers.IO) { repository.getNavigationData(navigationListModel) }
    }
}