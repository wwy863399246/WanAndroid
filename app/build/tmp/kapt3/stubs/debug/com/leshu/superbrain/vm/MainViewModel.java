package com.leshu.superbrain.vm;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2020/1/13 14:24
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/leshu/superbrain/vm/MainViewModel;", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "()V", "homeArticles", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/leshu/superbrain/data/bean/Article;", "getHomeArticles", "()Landroidx/lifecycle/MutableLiveData;", "listModel", "Lcom/leshu/superbrain/util/ListModel;", "getListModel", "mainRepository", "Lcom/leshu/superbrain/data/repository/MainRepository;", "getMainRepository", "()Lcom/leshu/superbrain/data/repository/MainRepository;", "mainRepository$delegate", "Lkotlin/Lazy;", "loadBanner", "Lkotlinx/coroutines/Job;", "loadHomeArticles", "isRefresh", "", "app_debug"})
public final class MainViewModel extends com.leshu.superbrain.vm.base.BaseViewModel {
    private final kotlin.Lazy mainRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.leshu.superbrain.data.bean.Article>> homeArticles = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel = null;
    
    private final com.leshu.superbrain.data.repository.MainRepository getMainRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.leshu.superbrain.data.bean.Article>> getHomeArticles() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> getListModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadBanner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadHomeArticles(boolean isRefresh) {
        return null;
    }
    
    public MainViewModel() {
        super();
    }
}