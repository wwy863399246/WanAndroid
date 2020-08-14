package com.wwy.android.vm

import com.wwy.android.data.repository.GetUserMsgUserCase
import com.wwy.android.vm.base.BaseViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/7 0007 下午 16:41
 *@描述
 */
class MyHomePageViewModel(private val userCase: GetUserMsgUserCase) : BaseViewModel() {
    var userLiveData = userCase.getUserMsg()
}