package com.wwy.android.vm

import androidx.lifecycle.MutableLiveData
import com.wwy.android.data.repository.GetUserMsgUserCase
import com.wwy.android.ext.CookieClass
import com.wwy.android.ext.setLoginState
import com.wwy.android.util.ListModel
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@创建者wwy
 *@创建时间 2020/8/18 0018 上午 2:12
 *@描述
 */
class SettingViewModel(private var getUserMsgUserCase: GetUserMsgUserCase) : BaseViewModel() {
    val mLoginStatus = MutableLiveData<ListModel<Int>>()
    fun loginOut() =
        launchUI {
            withContext(Dispatchers.IO) { getUserMsgUserCase.clearUserMsg(mLoginStatus) }
        }
}