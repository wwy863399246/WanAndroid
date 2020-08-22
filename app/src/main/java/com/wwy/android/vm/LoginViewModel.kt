package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.bean.User
import com.wwy.android.data.repository.LoginRepository
import com.wwy.android.vm.base.BaseViewModel
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.bean.base.ResultData.ErrorMessage
import com.wwy.android.util.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/10/28 16:03
 *@描述
 */
class LoginViewModel(private val repository: LoginRepository) : BaseViewModel() {
    val mLoginStatus = MutableLiveData<ListModel<Int>>()
    val mRegisterStatus = MutableLiveData<ListModel<Int>>()
    fun login(username: String, password: String) =
        launchUI {
            withContext(Dispatchers.IO) { repository.login(username, password, mLoginStatus) }
        }

    fun register(username: String, password: String, repassword: String) =
        launchUI {
            withContext(Dispatchers.IO) {
                repository.register(
                    username,
                    password,
                    repassword,
                    mRegisterStatus
                )
            }
        }

}