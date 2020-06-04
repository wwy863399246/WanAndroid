package com.leshu.superbrain.data.repository;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/25 10:43
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/leshu/superbrain/data/repository/LoginRepository;", "", "remoteDataSource", "Lcom/leshu/superbrain/data/repository/datasource/RemoteDataSource;", "(Lcom/leshu/superbrain/data/repository/datasource/RemoteDataSource;)V", "login", "Lcom/leshu/superbrain/data/bean/base/ResultData;", "Lcom/leshu/superbrain/data/bean/User;", "username", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLoggedInUser", "", "loggedInUser", "app_debug"})
public final class LoginRepository {
    private final com.leshu.superbrain.data.repository.datasource.RemoteDataSource remoteDataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.leshu.superbrain.data.bean.base.ResultData<com.leshu.superbrain.data.bean.User>> p2) {
        return null;
    }
    
    private final void setLoggedInUser(com.leshu.superbrain.data.bean.User loggedInUser) {
    }
    
    public LoginRepository(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.data.repository.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
}