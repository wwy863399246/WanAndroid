package com.leshu.superbrain.ui.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/17 14:53
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0014J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/leshu/superbrain/ui/base/BaseVMFragment;", "VM", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "Lcom/leshu/superbrain/ui/base/BaseFragment;", "()V", "mViewModel", "getMViewModel", "()Lcom/leshu/superbrain/vm/base/BaseViewModel;", "setMViewModel", "(Lcom/leshu/superbrain/vm/base/BaseViewModel;)V", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "initVM", "", "onDestroy", "onFragmentFirstVisible", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "providerVMClass", "Ljava/lang/Class;", "startObserve", "app_debug"})
public abstract class BaseVMFragment<VM extends com.leshu.superbrain.vm.base.BaseViewModel> extends com.leshu.superbrain.ui.base.BaseFragment {
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
    
    @java.lang.Override()
    protected void onFragmentFirstVisible() {
    }
    
    public void startObserve() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public BaseVMFragment() {
        super();
    }
}