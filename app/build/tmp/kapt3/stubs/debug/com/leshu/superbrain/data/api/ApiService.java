package com.leshu.superbrain.data.api;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/8 11:23
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J-\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\b0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\fH\'J.\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\b0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\fH\'J\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/leshu/superbrain/data/api/ApiService;", "", "getBanner", "Lcom/leshu/superbrain/data/bean/base/WanResponse;", "", "Lcom/leshu/superbrain/data/bean/Banner;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeArticles", "Lcom/leshu/superbrain/data/bean/WanListResponse;", "", "Lcom/leshu/superbrain/data/bean/Article;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjecNewData", "Lcom/leshu/superbrain/data/bean/AriticleResponse;", "pageNo", "getProjectDataByType", "cid", "getProjectTypes", "Lcom/leshu/superbrain/data/bean/ClassifyResponse;", "getStickArticles", "login", "Lcom/leshu/superbrain/data/bean/User;", "userName", "", "passWord", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    /**
     * 登录
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/user/login")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String passWord, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.WanResponse<com.leshu.superbrain.data.bean.User>> p2);
    
    /**
     * 获取banner数据
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/banner/json")
    public abstract java.lang.Object getBanner(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.WanResponse<? extends java.util.List<com.leshu.superbrain.data.bean.Banner>>> p0);
    
    /**
     * 获取首页文章数据
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/article/list/{page}/json")
    public abstract java.lang.Object getHomeArticles(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.WanResponse<com.leshu.superbrain.data.bean.WanListResponse<java.util.List<com.leshu.superbrain.data.bean.Article>>>> p1);
    
    /**
     * 获取置顶文章数据
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/article/top/json")
    public abstract java.lang.Object getStickArticles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.WanResponse<? extends java.util.List<com.leshu.superbrain.data.bean.Article>>> p0);
    
    /**
     * 项目分类
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/project/tree/json")
    public abstract java.lang.Object getProjectTypes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.WanResponse<? extends java.util.List<com.leshu.superbrain.data.bean.ClassifyResponse>>> p0);
    
    /**
     * 根据分类id获取项目数据
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/project/list/{page}/json")
    public abstract com.leshu.superbrain.data.bean.base.WanResponse<com.leshu.superbrain.data.bean.WanListResponse<java.util.List<com.leshu.superbrain.data.bean.AriticleResponse>>> getProjectDataByType(@retrofit2.http.Path(value = "page")
    int pageNo, @retrofit2.http.Query(value = "cid")
    int cid);
    
    /**
     * 获取最新项目数据
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/article/listproject/{page}/json")
    public abstract com.leshu.superbrain.data.bean.base.WanResponse<com.leshu.superbrain.data.bean.WanListResponse<java.util.List<com.leshu.superbrain.data.bean.AriticleResponse>>> getProjecNewData(@retrofit2.http.Path(value = "page")
    int pageNo);
}