package com.leshu.superbrain.adapter;

import java.lang.System;

/**
 * 自定义布局，图片
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u001f\u0012\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ,\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/leshu/superbrain/adapter/ImageAdapter;", "Lcom/youth/banner/adapter/BannerAdapter;", "Lcom/leshu/superbrain/data/bean/Banner;", "Lcom/leshu/superbrain/adapter/ImageAdapter$ImageHolder;", "mDatas", "", "mContext", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "onBindView", "", "holder", "data", "position", "", "size", "onCreateHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "ImageHolder", "app_debug"})
public final class ImageAdapter extends com.youth.banner.adapter.BannerAdapter<com.leshu.superbrain.data.bean.Banner, com.leshu.superbrain.adapter.ImageAdapter.ImageHolder> {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    
    public final void updateData(@org.jetbrains.annotations.Nullable()
    java.util.List<com.leshu.superbrain.data.bean.Banner> data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.leshu.superbrain.adapter.ImageAdapter.ImageHolder onCreateHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindView(@org.jetbrains.annotations.Nullable()
    com.leshu.superbrain.adapter.ImageAdapter.ImageHolder holder, @org.jetbrains.annotations.Nullable()
    com.leshu.superbrain.data.bean.Banner data, int position, int size) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    public ImageAdapter(@org.jetbrains.annotations.Nullable()
    java.util.List<com.leshu.superbrain.data.bean.Banner> mDatas, @org.jetbrains.annotations.NotNull()
    android.content.Context mContext) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/leshu/superbrain/adapter/ImageAdapter$ImageHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "app_debug"})
    public static final class ImageHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView imageView;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImageView() {
            return null;
        }
        
        public final void setImageView(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        public ImageHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}