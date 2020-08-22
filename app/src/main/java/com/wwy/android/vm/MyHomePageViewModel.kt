package com.wwy.android.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.wwy.android.data.bean.Article
import com.wwy.android.data.repository.GetUserMsgUserCase
import com.wwy.android.data.repository.ReadHistoryUserCase
import com.wwy.android.ext.CookieClass
import com.wwy.android.ext.getLoginState
import com.wwy.android.vm.base.BaseViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/7 0007 下午 16:41
 *@描述
 */
class MyHomePageViewModel(userCase: GetUserMsgUserCase, readHistoryUserCase: ReadHistoryUserCase) :
    BaseViewModel() {
    var userLiveData = userCase.getUserMsg()
    var readHistory: LiveData<List<Article>> =
        readHistoryUserCase.queryAllReadHistory().asLiveData()
}