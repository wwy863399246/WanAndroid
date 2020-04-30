package com.leshu.superbrain.vm.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/8 15:46
 * @描述 协程处理网络请求回调
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013J7\u0010\u0014\u001a\u00020\u00152\'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u00a2\u0006\u0002\b\u001c\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJA\u0010\u0014\u001a\u00020\u00152\'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0017\u00a2\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fR!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0010\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/leshu/superbrain/vm/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "finally", "Landroidx/lifecycle/MutableLiveData;", "", "getFinally", "()Landroidx/lifecycle/MutableLiveData;", "finally$delegate", "Lkotlin/Lazy;", "mException", "Ljava/lang/Exception;", "getMException", "mException$delegate", "start", "getStart", "start$delegate", "getError", "Landroidx/lifecycle/LiveData;", "launchUI", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "isNeedProgressBar", "(Lkotlin/jvm/functions/Function2;Z)Lkotlinx/coroutines/Job;", "app_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel implements androidx.lifecycle.LifecycleObserver {
    private final kotlin.Lazy mException$delegate = null;
    private final kotlin.Lazy finally$delegate = null;
    private final kotlin.Lazy start$delegate = null;
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Exception> getMException() {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getFinally() {
        return null;
    }
    
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getStart() {
        return null;
    }
    
    /**
     * 运行在UI线程的协程 viewModelScope 已经实现了在onCleared取消协程
     * @param isNeedProgressBar 是否需要进度条
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job launchUI(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block, boolean isNeedProgressBar) {
        return null;
    }
    
    /**
     * 运行在UI线程的协程 viewModelScope 已经实现了在onCleared取消协程
     * @param isNeedProgressBar 是否需要进度条
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job launchUI(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
        return null;
    }
    
    /**
     * 请求失败，出现异常
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Exception> getError() {
        return null;
    }
    
    /**
     * 请求完成，在此处做一些关闭操作
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getFinally() {
        return null;
    }
    
    /**
     * 请求开始，在此处做一些准备操作
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getStart() {
        return null;
    }
    
    public BaseViewModel() {
        super();
    }
}