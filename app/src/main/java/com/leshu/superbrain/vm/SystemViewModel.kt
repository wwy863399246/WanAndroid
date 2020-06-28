package com.leshu.superbrain.vm

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.ArticleUserCase
import com.leshu.superbrain.data.repository.SystemRepository
import com.leshu.superbrain.util.ListModel
import com.leshu.superbrain.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/6/24 16:35
 *@描述
 */
class SystemViewModel(
    private val repository: SystemRepository,
    private val userCase: ArticleUserCase
) : BaseViewModel() {
    val systemClassifyListModel= MutableLiveData<ListModel<ClassifyResponse>>()
    fun getSystemType() = launchUI {
        withContext(Dispatchers.IO) { repository.getSystemType(systemClassifyListModel) }
    }
}