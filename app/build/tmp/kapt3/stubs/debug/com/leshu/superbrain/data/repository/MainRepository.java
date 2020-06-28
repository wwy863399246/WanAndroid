package com.leshu.superbrain.data.repository;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2020/1/13 16:20
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/leshu/superbrain/data/repository/MainRepository;", "", "homeRemoteDataSource", "Lcom/leshu/superbrain/data/repository/datasource/RemoteDataSource;", "(Lcom/leshu/superbrain/data/repository/datasource/RemoteDataSource;)V", "currentPage", "", "getBanners", "Lcom/leshu/superbrain/data/bean/base/ResultData;", "", "Lcom/leshu/superbrain/data/bean/Banner;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStickArticles", "Lcom/leshu/superbrain/data/bean/Article;", "app_debug"})
public final class MainRepository {
    private int currentPage = 0;
    private final com.leshu.superbrain.data.repository.datasource.RemoteDataSource homeRemoteDataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends java.util.List<com.leshu.superbrain.data.bean.Banner>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStickArticles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends java.util.List<com.leshu.superbrain.data.bean.Article>>> p0) {
        return null;
    }
    
    public MainRepository(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.data.repository.datasource.RemoteDataSource homeRemoteDataSource) {
        super();
    }
}