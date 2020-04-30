package com.leshu.superbrain.view;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/18 13:58
 * @描述
 */
@android.annotation.SuppressLint(value = {"NewApi"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J#\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\u0002\u0010 J\u0012\u0010!\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\"\u001a\u00020\u0007J\u0012\u0010!\u001a\u00020\u0007*\u00020#2\u0006\u0010\"\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/leshu/superbrain/view/CustomNavigationBarView;", "Landroid/widget/Toolbar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLeftImg", "mLeftTextId", "mLeftTextStr", "", "mRightImg1", "mRightImg2", "mRightImg3", "mShowLeftImg", "", "mShowRightImg1", "mShowRightImg2", "mShowRightImg3", "mShowTabLayout", "mTextColor", "mTitleTextId", "mTitleTextStr", "initView", "", "setTabLayoutData", "tablayoutTitle", "", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "([Ljava/lang/String;Landroidx/viewpager2/widget/ViewPager2;)V", "color", "colorRes", "Landroid/view/View;", "app_debug"})
public final class CustomNavigationBarView extends android.widget.Toolbar {
    private int mLeftImg;
    private java.lang.String mLeftTextStr;
    private int mLeftTextId;
    private int mRightImg1;
    private int mRightImg2;
    private int mRightImg3;
    private boolean mShowLeftImg;
    private boolean mShowRightImg1;
    private boolean mShowRightImg2;
    private boolean mShowRightImg3;
    private java.lang.String mTitleTextStr;
    private int mTitleTextId;
    private int mTextColor;
    private boolean mShowTabLayout;
    private java.util.HashMap _$_findViewCache;
    
    private final void initView() {
    }
    
    public final void setTabLayoutData(@org.jetbrains.annotations.NotNull()
    java.lang.String[] tablayoutTitle, @org.jetbrains.annotations.NotNull()
    androidx.viewpager2.widget.ViewPager2 viewPager2) {
    }
    
    public final int color(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$color, int colorRes) {
        return 0;
    }
    
    public final int color(@org.jetbrains.annotations.NotNull()
    android.view.View $this$color, int colorRes) {
        return 0;
    }
    
    public CustomNavigationBarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public CustomNavigationBarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public CustomNavigationBarView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}