package com.wwy.wanandroid.ui.member

import androidx.lifecycle.MutableLiveData
import com.wwy.wanandroid.bean.User
import com.wwy.wanandroid.repository.LoginRepository
import com.wwy.wanandroid.ui.base.BaseViewModel
import com.wwy.wanandroid.bean.base.Result

/**
 *@创建者wwy
 *@创建时间 2019/10/28 16:03
 *@描述
 */
class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    val user: MutableLiveData<User> = MutableLiveData()
    fun login(username: String, password: String) {
        launchUI({
            val result = loginRepository.login(username, password)
            if (result is Result.Success) {
                user.value = result.data
            }
        }, true)
    }

}