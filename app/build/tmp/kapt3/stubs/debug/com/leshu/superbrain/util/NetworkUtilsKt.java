package com.leshu.superbrain.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001aE\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"isInternetAvailable", "", "safeApiCall", "Lcom/leshu/superbrain/data/bean/base/ResultData;", "T", "", "call", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class NetworkUtilsKt {
    
    /**
     * @创建者wwy
     * @创建时间 2019/10/25 16:09
     * @描述 网络请求类
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>java.lang.Object safeApiCall(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends T>>, ? extends java.lang.Object> call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends T>> p1) {
        return null;
    }
    
    /**
     * 判断网络状态是否可用
     */
    @kotlin.Suppress(names = {"DEPRECATION"})
    public static final boolean isInternetAvailable() {
        return false;
    }
}