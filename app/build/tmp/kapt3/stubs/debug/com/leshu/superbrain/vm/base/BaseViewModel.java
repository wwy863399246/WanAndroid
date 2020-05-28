package com.leshu.superbrain.vm.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/8 15:46
 * @描述 协程处理网络请求回调
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\'\u0010\u0006\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007\u00a2\u0006\u0002\b\f\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/leshu/superbrain/vm/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "launchUI", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "app_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel implements androidx.lifecycle.LifecycleObserver {
    
    /**
     * 运行在UI线程的协程 viewModelScope 已经实现了在onCleared取消协程
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job launchUI(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
        return null;
    }
    
    public BaseViewModel() {
        super();
    }
}