package com.leshu.superbrain.data.repository.datasource;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/11/12 9:52
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ3\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ3\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/leshu/superbrain/data/repository/datasource/ProjectRemoteDataSource;", "", "()V", "getLatestProjectList", "Lcom/leshu/superbrain/data/bean/base/ResultData;", "Lcom/leshu/superbrain/data/bean/WanListResponse;", "", "Lcom/leshu/superbrain/data/bean/Article;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjectClassify", "Lcom/leshu/superbrain/data/bean/ClassifyResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProjectTypeDetailList", "cid", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLatestProjectList", "requestProjectClassify", "requestProjectTypeDetailList", "app_debug"})
public final class ProjectRemoteDataSource {
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProjectClassify(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<? extends java.util.List<com.leshu.superbrain.data.bean.ClassifyResponse>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLatestProjectList(int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<com.leshu.superbrain.data.bean.WanListResponse<java.util.List<com.leshu.superbrain.data.bean.Article>>>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProjectTypeDetailList(int page, int cid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<com.leshu.superbrain.data.bean.WanListResponse<java.util.List<com.leshu.superbrain.data.bean.Article>>>> p2) {
        return null;
    }
    
    public ProjectRemoteDataSource() {
        super();
    }
}