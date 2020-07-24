package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.User
import com.wwy.android.data.repository.LoginRepository
import com.wwy.android.vm.base.BaseViewModel
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.bean.base.ResultData.ErrorMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/28 16:03
 *@描述
 */
class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {
    val user: MutableLiveData<User> = MutableLiveData()
    val loginErrorMsg: MutableLiveData<String> = MutableLiveData()
    fun login(username: String, password: String) {
        launchUI {
            val result = withContext(Dispatchers.IO) { repository.login(username, password) }
            if (result is ResultData.Success) {
                user.value = result.data
            } else if (result is ResultData.ErrorMessage) {
                loginErrorMsg.value = result.message
            }
        }
    }

}