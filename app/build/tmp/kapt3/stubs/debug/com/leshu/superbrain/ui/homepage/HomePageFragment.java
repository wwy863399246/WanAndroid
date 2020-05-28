package com.leshu.superbrain.ui.homepage;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/17 11:58
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/leshu/superbrain/ui/homepage/HomePageFragment;", "Lcom/leshu/superbrain/ui/base/BaseVMFragment;", "Lcom/leshu/superbrain/vm/MainViewModel;", "Lcom/chad/library/adapter/base/listener/OnLoadMoreListener;", "()V", "homePageAdapter", "Lcom/leshu/superbrain/adapter/HomePageAdapter;", "homePageHeadView", "Lcom/leshu/superbrain/view/HomePageHeadView;", "homePageStickAdapter", "Lcom/leshu/superbrain/ui/homepage/HomePageFragment$HomePageStickAdapter;", "loadPageView", "Lcom/leshu/superbrain/view/loadpage/BasePageStateView;", "rootView", "Lcom/leshu/superbrain/view/loadpage/LoadPageView;", "initData", "", "initView", "onLoadMore", "onStart", "onStop", "providerVMClass", "Ljava/lang/Class;", "refresh", "setLayoutResId", "", "startObserve", "HomePageStickAdapter", "app_debug"})
public final class HomePageFragment extends com.leshu.superbrain.ui.base.BaseVMFragment<com.leshu.superbrain.vm.MainViewModel> implements com.chad.library.adapter.base.listener.OnLoadMoreListener {
    private final com.leshu.superbrain.adapter.HomePageAdapter homePageAdapter = null;
    private final com.leshu.superbrain.ui.homepage.HomePageFragment.HomePageStickAdapter homePageStickAdapter = null;
    private final com.leshu.superbrain.view.loadpage.BasePageStateView loadPageView = null;
    private com.leshu.superbrain.view.loadpage.LoadPageView rootView;
    private com.leshu.superbrain.view.HomePageHeadView homePageHeadView;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Class<com.leshu.superbrain.vm.MainViewModel> providerVMClass() {
        return null;
    }
    
    @java.lang.Override()
    public int setLayoutResId() {
        return 0;
    }
    
    @java.lang.Override()
    public void initData() {
    }
    
    @java.lang.Override()
    public void initView() {
    }
    
    private final void refresh() {
    }
    
    @java.lang.Override()
    public void startObserve() {
    }
    
    @java.lang.Override()
    public void onLoadMore() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    public HomePageFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\t"}, d2 = {"Lcom/leshu/superbrain/ui/homepage/HomePageFragment$HomePageStickAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/leshu/superbrain/data/bean/Article;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_debug"})
    public static final class HomePageStickAdapter extends com.chad.library.adapter.base.BaseQuickAdapter<com.leshu.superbrain.data.bean.Article, com.chad.library.adapter.base.viewholder.BaseViewHolder> {
        
        @java.lang.Override()
        protected void convert(@org.jetbrains.annotations.NotNull()
        com.chad.library.adapter.base.viewholder.BaseViewHolder holder, @org.jetbrains.annotations.NotNull()
        com.leshu.superbrain.data.bean.Article item) {
        }
        
        public HomePageStickAdapter() {
            super(0, null);
        }
    }
}