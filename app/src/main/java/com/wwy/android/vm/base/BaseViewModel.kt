package com.wwy.android.vm.base

import androidx.lifecycle.*
import kotlinx.coroutines.*

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:46
 *@描述 协程处理网络请求回调
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    /**
     * 运行在UI线程的协程 viewModelScope 已经实现了在onCleared取消协程
     */
    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch {
        block()
    }

}