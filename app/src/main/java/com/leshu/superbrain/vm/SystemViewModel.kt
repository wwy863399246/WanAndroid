package com.leshu.superbrain.vm

import com.leshu.superbrain.data.bean.base.ResultData
import com.leshu.superbrain.data.repository.ArticleUserCase
import com.leshu.superbrain.data.repository.SystemRepository
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
    fun getSystemType() = launchUI {
        var result = withContext(Dispatchers.IO) { repository.getSystemType() }
        if(result is ResultData.Success){
            
        }
    }

}