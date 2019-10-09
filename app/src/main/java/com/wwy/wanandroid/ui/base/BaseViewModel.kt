package com.wwy.wanandroid.ui.base

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

/**
 *@创建者wwy
 *@创建时间 2019/10/8 15:46
 *@描述
 */
open class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {
    val mException: MutableLiveData<Throwable> = MutableLiveData()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private val mLaunchManager: MutableList<Job> = mutableListOf()
    protected fun launchOnUITryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        cacheBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean
    ) {
        launchOnUI {
            tryCatch(tryBlock, cacheBlock, finallyBlock, handleCancellationExceptionManually)
        }
    }

    /**
     * add launch task to [mLaunchManager]
     */
    private fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        val job = launch { block() }
        mLaunchManager.add(job)
        job.invokeOnCompletion { mLaunchManager.remove(job) }

    }

    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit,
        handleCancellationExceptionManually: Boolean = false
    ) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                if (e !is CancellationException || handleCancellationExceptionManually) {
                    mException.value = e
                    catchBlock(e)
                } else {
                    throw e
                }
            } finally {
                finallyBlock()
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        Timber.tag("wwy").d("onDestory")
        clearLaunchTask()
    }

    private fun clearLaunchTask() {
        mLaunchManager.clear()
    }
}