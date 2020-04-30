package com.leshu.superbrain.ui.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/17 14:53
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH&J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0017\u0010\u001f\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016\u00a2\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016\u00a2\u0006\u0002\u0010!J\b\u0010#\u001a\u00020$H&J\b\u0010%\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006&"}, d2 = {"Lcom/leshu/superbrain/ui/base/BaseVMFragment;", "VM", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "()V", "mViewModel", "getMViewModel", "()Lcom/leshu/superbrain/vm/base/BaseViewModel;", "setMViewModel", "(Lcom/leshu/superbrain/vm/base/BaseViewModel;)V", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "initData", "", "initVM", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "providerVMClass", "Ljava/lang/Class;", "requestError", "it", "Ljava/lang/Exception;", "requestFinally", "", "(Ljava/lang/Boolean;)V", "requestStart", "setLayoutResId", "", "startObserve", "app_debug"})
public abstract class BaseVMFragment<VM extends com.leshu.superbrain.vm.base.BaseViewModel> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    protected VM mViewModel;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    protected final VM getMViewModel() {
        return null;
    }
    
    protected final void setMViewModel(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public java.lang.Class<VM> providerVMClass() {
        return null;
    }
    
    private final void initVM() {
    }
    
    public abstract int setLayoutResId();
    
    public abstract void initView();
    
    public abstract void initData();
    
    public void startObserve() {
    }
    
    /**
     * 请求完成 可以做完成之后的操作
     * @param it 是否需要进度条
     */
    public void requestFinally(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean it) {
    }
    
    /**
     * 请求开始 请求完成 可以做开始准备的操作
     * @param it 是否需要进度条
     */
    public void requestStart(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean it) {
    }
    
    /**
     * 常见异常处理
     */
    private final void requestError(java.lang.Exception it) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public BaseVMFragment() {
        super();
    }
}