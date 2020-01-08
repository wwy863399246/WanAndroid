package com.leshu.superbrain.ui.member

import androidx.lifecycle.MutableLiveData
import com.leshu.superbrain.data.bean.User
import com.leshu.superbrain.data.repository.LoginRepository
import com.leshu.superbrain.ui.base.BaseViewModel
import com.leshu.superbrain.data.bean.base.ResultData
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/28 16:03
 *@描述
 */
class LoginViewModel : BaseViewModel() {
    private val repository by lazy { LoginRepository() }
    val user: MutableLiveData<User> = MutableLiveData()
    fun login(username: String, password: String) {
        Timber.tag("wangwuyuan").e("点击了")
        launchUI({
            val result = repository.login(username, password)
            if (result is ResultData.Success) {
                user.value = result.data
            }
        }, true)
    }

}