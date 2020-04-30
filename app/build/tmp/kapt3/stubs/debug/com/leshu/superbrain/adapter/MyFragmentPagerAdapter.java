package com.leshu.superbrain.adapter;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/20 15:04
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/leshu/superbrain/adapter/MyFragmentPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "mFragments", "", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/FragmentActivity;Ljava/util/List;)V", "createFragment", "position", "", "getItemCount", "app_debug"})
public final class MyFragmentPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    private final java.util.List<androidx.fragment.app.Fragment> mFragments = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment createFragment(int position) {
        return null;
    }
    
    public MyFragmentPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentActivity fragmentActivity, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends androidx.fragment.app.Fragment> mFragments) {
        super(null);
    }
}