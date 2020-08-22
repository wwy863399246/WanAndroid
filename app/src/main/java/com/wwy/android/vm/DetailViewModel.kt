package com.wwy.android.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.coder.zzq.smartshow.toast.SmartToast
import com.wwy.android.data.api.RetrofitClient
import com.wwy.android.data.bean.Article
import com.wwy.android.data.bean.base.ResultData
import com.wwy.android.data.repository.CollectUserCase
import com.wwy.android.data.repository.ReadHistoryUserCase
import com.wwy.android.ext.CookieClass
import com.wwy.android.ext.getLoginState
import com.wwy.android.vm.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


/**
 *@创建者wwy
 *@创建时间 2020/8/10 0010 下午 17:51
 *@描述
 */
class DetailViewModel(
    private val collectUserCase: CollectUserCase,
    private val readHistoryUserCase: ReadHistoryUserCase
) : BaseViewModel() {
    var collectLiveData: MutableLiveData<Int> = MutableLiveData()
    var unCollectLiveData: MutableLiveData<Int> = MutableLiveData()
    fun collect(id: Int) {
        launchUI {
            val result = withContext(Dispatchers.IO) { collectUserCase.collect(id) }
            if (result is ResultData.Success) {
                collectLiveData.value = 1
            } else {
                collectLiveData.value = 0
            }
        }
    }

    fun unCollect(id: Int) {
        launchUI {
            val result = withContext(Dispatchers.IO) { collectUserCase.unCollect(id) }
            if (result is ResultData.Success) {
                unCollectLiveData.value = 1
            } else {
                unCollectLiveData.value = 0
            }
        }
    }

//    var collectLiveData1: (Int) -> LiveData<Int> = fun(id: Int) = liveData<Int> {
//        if (collectUserCase.collect(id) is ResultData.Success) {
//            emit(1)
//        } else {
//            emit(0)
//        }
//    }

    fun isLogin(): Boolean = getLoginState() && CookieClass.hasCookie()
    fun saveReadHistory(article: Article) = launchUI {
        withContext(Dispatchers.IO) { readHistoryUserCase.addReadHistory(article) }
    }

}
