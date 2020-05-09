package com.leshu.superbrain.data.repository;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2020/1/13 16:20
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ1\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/leshu/superbrain/data/repository/MainRepository;", "", "()V", "currentPage", "", "homeRemoteDataSource", "Lcom/leshu/superbrain/data/repository/datasource/HomeRemoteDataSource;", "getHomeRemoteDataSource", "()Lcom/leshu/superbrain/data/repository/datasource/HomeRemoteDataSource;", "homeRemoteDataSource$delegate", "Lkotlin/Lazy;", "getBanners", "Lcom/leshu/superbrain/data/bean/base/ResultData;", "", "Lcom/leshu/superbrain/data/bean/Banner;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeArticles", "", "isRefresh", "", "listModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/leshu/superbrain/util/ListModel;", "Lcom/leshu/superbrain/data/bean/Article;", "(ZLandroidx/lifecycle/MutableLiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MainRepository {
    private int currentPage;
    private final kotlin.Lazy homeRemoteDataSource$delegate = null;
    
    private final com.leshu.superbrain.data.repository.datasource.HomeRemoteDataSource getHomeRemoteDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends java.util.List<com.leshu.superbrain.data.bean.Banner>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHomeArticles(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    public MainRepository() {
        super();
    }
}