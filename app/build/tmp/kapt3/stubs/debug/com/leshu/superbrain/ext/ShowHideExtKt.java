package com.leshu.superbrain.ext;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0002\u00a2\u0006\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002\u001a7\u0010\r\u001a\u00020\u0001*\u00020\t2\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t\u00a2\u0006\u0002\u0010\u000e\u001a7\u0010\r\u001a\u00020\u0001*\u00020\u000f2\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t\u00a2\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0001*\u00020\t2\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t\u001a\u001c\u0010\u0011\u001a\u00020\u0001*\u00020\u000f2\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\t2\u0006\u0010\f\u001a\u00020\t\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\f\u001a\u00020\t\u00a8\u0006\u0014"}, d2 = {"loadFragmentsTransaction", "", "containerViewId", "", "showPosition", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "(IILandroidx/fragment/app/FragmentManager;[Landroidx/fragment/app/Fragment;)V", "showHideFragmentTransaction", "showFragment", "loadFragments", "(Landroidx/fragment/app/Fragment;II[Landroidx/fragment/app/Fragment;)V", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;II[Landroidx/fragment/app/Fragment;)V", "loadRootFragment", "rootFragment", "showHideFragment", "app_debug"})
public final class ShowHideExtKt {
    
    /**
     * 加载根Fragment
     * @param containerViewId 布局id
     * @param rootFragment  根fragment
     */
    public static final void loadRootFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$loadRootFragment, @androidx.annotation.IdRes()
    int containerViewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment rootFragment) {
    }
    
    /**
     * 加载同级的Fragment
     * @param containerViewId 布局id
     * @param showPosition  默认显示的角标
     * @param fragments    加载的fragment
     */
    public static final void loadFragments(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$loadFragments, @androidx.annotation.IdRes()
    int containerViewId, int showPosition, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment... fragments) {
    }
    
    /**
     * 显示目标fragment，并隐藏其他fragment
     * @param showFragment 需要显示的fragment
     */
    public static final void showHideFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment $this$showHideFragment, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment showFragment) {
    }
    
    /**
     * 加载根Fragment
     * @param containerViewId 布局id
     * @param rootFragment  根fragment
     */
    public static final void loadRootFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity $this$loadRootFragment, @androidx.annotation.IdRes()
    int containerViewId, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment rootFragment) {
    }
    
    /**
     * 加载同级的Fragment
     * @param containerViewId 布局id
     * @param showPosition  默认显示的角标
     * @param fragments    加载的fragment
     */
    public static final void loadFragments(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity $this$loadFragments, @androidx.annotation.IdRes()
    int containerViewId, int showPosition, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment... fragments) {
    }
    
    /**
     * 显示目标fragment，并隐藏其他fragment
     * @param showFragment 需要显示的fragment
     */
    public static final void showHideFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity $this$showHideFragment, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment showFragment) {
    }
    
    /**
     * 使用add+show+hide模式加载fragment
     *
     * 默认显示位置[showPosition]的Fragment，最大Lifecycle为Lifecycle.State.RESUMED
     * 其他隐藏的Fragment，最大Lifecycle为Lifecycle.State.STARTED
     *
     * @param containerViewId 容器id
     * @param showPosition  fragments
     * @param fragmentManager FragmentManager
     * @param fragments  控制显示的Fragments
     */
    private static final void loadFragmentsTransaction(@androidx.annotation.IdRes()
    int containerViewId, int showPosition, androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment... fragments) {
    }
    
    /**
     * 显示需要显示的Fragment[showFragment]，并设置其最大Lifecycle为Lifecycle.State.RESUMED。
     * 同时隐藏其他Fragment,并设置最大Lifecycle为Lifecycle.State.STARTED
     * @param fragmentManager
     * @param showFragment
     */
    private static final void showHideFragmentTransaction(androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment showFragment) {
    }
}