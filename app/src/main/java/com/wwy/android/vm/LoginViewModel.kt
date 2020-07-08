package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.User
import com.wwy.android.data.repository.LoginRepository
import com.wwy.android.vm.base.BaseViewModel
import com.wwy.android.data.bean.base.ResultData
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/28 16:03
 *@描述
 */
class LoginViewModel(private val repository: LoginRepository): BaseViewModel() {

    val user: MutableLiveData<User> = MutableLiveData()
    fun login(username: String, password: String) {
        Timber.tag("wangwuyuan").e("点击了")
        launchUI {
            val result = repository.login(username, password)
            if (result is ResultData.Success) {
                user.value = result.data
            }
        }
    }

}