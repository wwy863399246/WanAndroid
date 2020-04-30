package com.leshu.superbrain.ui.member;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/28 16:03
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/leshu/superbrain/ui/member/LoginViewModel;", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "()V", "repository", "Lcom/leshu/superbrain/data/repository/LoginRepository;", "getRepository", "()Lcom/leshu/superbrain/data/repository/LoginRepository;", "repository$delegate", "Lkotlin/Lazy;", "user", "Landroidx/lifecycle/MutableLiveData;", "Lcom/leshu/superbrain/data/bean/User;", "getUser", "()Landroidx/lifecycle/MutableLiveData;", "login", "", "username", "", "password", "app_debug"})
public final class LoginViewModel extends com.leshu.superbrain.vm.base.BaseViewModel {
    private final kotlin.Lazy repository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.data.bean.User> user = null;
    
    private final com.leshu.superbrain.data.repository.LoginRepository getRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.data.bean.User> getUser() {
        return null;
    }
    
    public final void login(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
    }
    
    public LoginViewModel() {
        super();
    }
}