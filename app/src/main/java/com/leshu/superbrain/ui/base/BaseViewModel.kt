package com.leshu.superbrain.ui.base

import androidx.lifecycle.*
import kotlinx.coroutines.*
import java.lang.Exception

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:46
 *@描述 协程处理网络请求回调
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {
    private val mException by lazy { MutableLiveData<Exception>() }
    private val finally by lazy { MutableLiveData<Boolean>() }
    private val start by lazy { MutableLiveData<Boolean>() }

    /**
     * 运行在UI线程的协程 viewModelScope 已经实现了在onCleared取消协程
     * @param isNeedProgressBar 是否需要进度条
     */
    fun launchUI(block: suspend CoroutineScope.() -> Unit, isNeedProgressBar: Boolean = false) = viewModelScope.launch {
        try {
            start.value = isNeedProgressBar
            block()
        } catch (e: Exception) {
            mException.value = e
        } finally {
            finally.value = isNeedProgressBar
        }
    }

    /**
     * 请求失败，出现异常
     */
    fun getError(): LiveData<Exception> {
        return mException
    }

    /**
     * 请求完成，在此处做一些关闭操作
     */
    fun getFinally(): LiveData<Boolean> {
        return finally
    }

    /**
     * 请求开始，在此处做一些准备操作
     */
    fun getStart(): LiveData<Boolean> {
        return start
    }
}