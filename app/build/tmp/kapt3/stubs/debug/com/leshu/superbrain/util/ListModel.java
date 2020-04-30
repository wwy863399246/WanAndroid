package com.leshu.superbrain.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BM\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\fJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\\\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\rR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/leshu/superbrain/util/ListModel;", "T", "", "showSuccess", "", "showLoading", "", "showError", "", "showEnd", "isRefresh", "needLogin", "(Ljava/util/List;ZLjava/lang/String;ZZLjava/lang/Boolean;)V", "()Z", "getNeedLogin", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowEnd", "getShowError", "()Ljava/lang/String;", "getShowLoading", "getShowSuccess", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;ZLjava/lang/String;ZZLjava/lang/Boolean;)Lcom/leshu/superbrain/util/ListModel;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ListModel<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<T> showSuccess = null;
    private final boolean showLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String showError = null;
    private final boolean showEnd = false;
    private final boolean isRefresh = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean needLogin = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> getShowSuccess() {
        return null;
    }
    
    public final boolean getShowLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getShowError() {
        return null;
    }
    
    public final boolean getShowEnd() {
        return false;
    }
    
    public final boolean isRefresh() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getNeedLogin() {
        return null;
    }
    
    public ListModel(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> showSuccess, boolean showLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String showError, boolean showEnd, boolean isRefresh, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean needLogin) {
        super();
    }
    
    public ListModel() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.leshu.superbrain.util.ListModel<T> copy(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> showSuccess, boolean showLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String showError, boolean showEnd, boolean isRefresh, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean needLogin) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}