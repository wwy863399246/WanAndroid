package com.leshu.superbrain.data.repository.datasource;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/30 9:54
 * @描述 首页远程数据类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\t0\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J+\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\t0\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/leshu/superbrain/data/repository/datasource/HomeRemoteDataSource;", "", "()V", "getBanners", "Lcom/leshu/superbrain/data/bean/base/ResultData;", "", "Lcom/leshu/superbrain/data/bean/BannerResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeArticles", "Lcom/leshu/superbrain/data/bean/WanListResponse;", "Lcom/leshu/superbrain/data/bean/Article;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestBanners", "requestHomeArticles", "app_debug"})
public final class HomeRemoteDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHomeArticles(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<com.leshu.superbrain.data.bean.WanListResponse<java.util.List<com.leshu.superbrain.data.bean.Article>>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBanners(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends java.util.List<com.leshu.superbrain.data.bean.BannerResponse>>> p0) {
        return null;
    }
    
    public HomeRemoteDataSource() {
        super();
    }
}