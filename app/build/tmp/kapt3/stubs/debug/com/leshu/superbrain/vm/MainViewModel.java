package com.leshu.superbrain.vm;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2020/1/13 14:24
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001aR\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001b"}, d2 = {"Lcom/leshu/superbrain/vm/MainViewModel;", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "()V", "mBanner", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/leshu/superbrain/data/bean/Banner;", "getMBanner", "()Landroidx/lifecycle/MutableLiveData;", "mListModel", "Lcom/leshu/superbrain/util/ListModel;", "Lcom/leshu/superbrain/data/bean/Article;", "getMListModel", "mLoadPageStatus", "Lcom/leshu/superbrain/view/loadpage/LoadPageStatus;", "getMLoadPageStatus", "mainRepository", "Lcom/leshu/superbrain/data/repository/MainRepository;", "getMainRepository", "()Lcom/leshu/superbrain/data/repository/MainRepository;", "mainRepository$delegate", "Lkotlin/Lazy;", "loadBanner", "Lkotlinx/coroutines/Job;", "loadHomeArticles", "isRefresh", "", "app_debug"})
public final class MainViewModel extends com.leshu.superbrain.vm.base.BaseViewModel {
    private final kotlin.Lazy mainRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.leshu.superbrain.data.bean.Banner>> mBanner = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> mLoadPageStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> mListModel = null;
    
    private final com.leshu.superbrain.data.repository.MainRepository getMainRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.leshu.superbrain.data.bean.Banner>> getMBanner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> getMLoadPageStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> getMListModel() {
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