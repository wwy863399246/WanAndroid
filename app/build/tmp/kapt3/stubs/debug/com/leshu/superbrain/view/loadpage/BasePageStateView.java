package com.leshu.superbrain.view.loadpage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0014\u0010\u0011\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/leshu/superbrain/view/loadpage/BasePageStateView;", "", "()V", "convert", "", "loadPageView", "Lcom/leshu/superbrain/view/loadpage/LoadPageView;", "loadPageStatus", "Lcom/leshu/superbrain/view/loadpage/LoadPageStatus;", "getLoadEmptyView", "Landroid/view/View;", "getLoadFailView", "getLoadNoNetView", "getLoadingView", "getRootView", "activity", "Landroid/app/Activity;", "isVisible", "visible", "", "app_debug"})
public abstract class BasePageStateView {
    
    /**
     * 根布局
     * @param parent ViewGroup
     * @return View
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getRootView(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity);
    
    /**
     * 布局中的 加载更多视图
     * @return View
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getLoadingView(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.view.loadpage.LoadPageView loadPageView);
    
    /**
     * 布局中的 加载失败布局
     * @return View
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getLoadFailView(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.view.loadpage.LoadPageView loadPageView);
    
    /**
     * 布局中的 加载空布局
     * @return View
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getLoadEmptyView(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.view.loadpage.LoadPageView loadPageView);
    
    /**
     * 布局中的 加载无网络布局
     * @return View
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.view.View getLoadNoNetView(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.view.loadpage.LoadPageView loadPageView);
    
    /**
     * 可重写此方式，实行自定义逻辑
     * @param holder BaseViewHolder
     * @param position Int
     * @param loadPageStatus loadPageStatus
     */
    public void convert(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.view.loadpage.LoadPageView loadPageView, @org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.view.loadpage.LoadPageStatus loadPageStatus) {
    }
    
    private final void isVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$isVisible, boolean visible) {
    }
    
    public BasePageStateView() {
        super();
    }
}