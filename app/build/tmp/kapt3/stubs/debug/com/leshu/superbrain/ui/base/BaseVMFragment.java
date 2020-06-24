package com.leshu.superbrain.ui.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/17 14:53
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001c\u0010\u0005\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/leshu/superbrain/ui/base/BaseVMFragment;", "VM", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "Lcom/leshu/superbrain/ui/base/BaseFragment;", "()V", "mViewModel", "getMViewModel", "()Lcom/leshu/superbrain/vm/base/BaseViewModel;", "setMViewModel", "(Lcom/leshu/superbrain/vm/base/BaseViewModel;)V", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "initVM", "onFragmentFirstVisible", "", "startObserve", "app_debug"})
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
    protected void onFragmentFirstVisible() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract VM initVM();
    
    public void startObserve() {
    }
    
    public BaseVMFragment() {
        super();
    }
}