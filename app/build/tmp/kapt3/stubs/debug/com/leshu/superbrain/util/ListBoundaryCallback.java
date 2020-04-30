package com.leshu.superbrain.util;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/11/6 10:27
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/leshu/superbrain/util/ListBoundaryCallback;", "Value", "Landroidx/paging/PagedList$BoundaryCallback;", "listLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/leshu/superbrain/util/ListStatus;", "(Landroidx/lifecycle/MutableLiveData;)V", "onItemAtEndLoaded", "", "itemAtEnd", "(Ljava/lang/Object;)V", "onItemAtFrontLoaded", "itemAtFront", "onZeroItemsLoaded", "app_debug"})
public final class ListBoundaryCallback<Value extends java.lang.Object> extends androidx.paging.PagedList.BoundaryCallback<Value> {
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListStatus> listLiveData = null;
    
    @java.lang.Override()
    public void onZeroItemsLoaded() {
    }
    
    @java.lang.Override()
    public void onItemAtEndLoaded(Value itemAtEnd) {
    }
    
    @java.lang.Override()
    public void onItemAtFrontLoaded(Value itemAtFront) {
    }
    
    public ListBoundaryCallback(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListStatus> listLiveData) {
        super();
    }
}