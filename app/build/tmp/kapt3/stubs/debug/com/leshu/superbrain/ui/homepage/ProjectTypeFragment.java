package com.leshu.superbrain.ui.homepage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/leshu/superbrain/ui/homepage/ProjectTypeFragment;", "Lcom/leshu/superbrain/ui/base/BaseVMFragment;", "Lcom/leshu/superbrain/vm/HomeProjectViewModel;", "Lcom/chad/library/adapter/base/listener/OnLoadMoreListener;", "()V", "cid", "", "getCid", "()Ljava/lang/Integer;", "cid$delegate", "Lkotlin/Lazy;", "homePageAdapter", "Lcom/leshu/superbrain/adapter/HomePageAdapter;", "i", "loadPageView", "Lcom/leshu/superbrain/view/loadpage/BasePageStateView;", "rootView", "Lcom/leshu/superbrain/view/loadpage/LoadPageView;", "initData", "", "initVM", "initView", "onLoadMore", "refresh", "setLayoutResId", "startObserve", "Companion", "app_debug"})
public final class ProjectTypeFragment extends com.leshu.superbrain.ui.base.BaseVMFragment<com.leshu.superbrain.vm.HomeProjectViewModel> implements com.chad.library.adapter.base.listener.OnLoadMoreListener {
    private final kotlin.Lazy cid$delegate = null;
    private final com.leshu.superbrain.adapter.HomePageAdapter homePageAdapter = null;
    private final com.leshu.superbrain.view.loadpage.BasePageStateView loadPageView = null;
    private com.leshu.superbrain.view.loadpage.LoadPageView rootView;
    private int i;
    private static final java.lang.String CID = "projectCid";
    public static final com.leshu.superbrain.ui.homepage.ProjectTypeFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.leshu.superbrain.vm.HomeProjectViewModel initVM() {
        return null;
    }
    
    @java.lang.Override()
    public int setLayoutResId() {
        return 0;
    }
    
    private final java.lang.Integer getCid() {
        return null;
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    @java.lang.Override()
    public void startObserve() {
    }
    
    @java.lang.Override()
    public void initData() {
    }
    
    private final void refresh() {
    }
    
    @java.lang.Override()
    public void onLoadMore() {
    }
    
    public ProjectTypeFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/leshu/superbrain/ui/homepage/ProjectTypeFragment$Companion;", "", "()V", "CID", "", "newInstance", "Lcom/leshu/superbrain/ui/homepage/ProjectTypeFragment;", "cid", "", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.leshu.superbrain.ui.homepage.ProjectTypeFragment newInstance(int cid) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}