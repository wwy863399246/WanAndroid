package com.leshu.superbrain.app;

import java.lang.System;

/**
 * Glide module configurations
 */
@com.bumptech.glide.annotation.GlideModule()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u0004*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/leshu/superbrain/app/MyGlideModule;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "applyOptions", "", "context", "Landroid/content/Context;", "builder", "Lcom/bumptech/glide/GlideBuilder;", "isManifestParsingEnabled", "", "swap", "Lcom/bumptech/glide/request/RequestOptions;", "format", "Lcom/bumptech/glide/load/DecodeFormat;", "app_debug"})
public final class MyGlideModule extends com.bumptech.glide.module.AppGlideModule {
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void applyOptions(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bumptech.glide.GlideBuilder builder) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final void swap(@org.jetbrains.annotations.NotNull()
    com.bumptech.glide.request.RequestOptions $this$swap, @org.jetbrains.annotations.NotNull()
    com.bumptech.glide.load.DecodeFormat format, @org.jetbrains.annotations.NotNull()
    com.bumptech.glide.GlideBuilder builder) {
    }
    
    @java.lang.Override()
    public boolean isManifestParsingEnabled() {
        return false;
    }
    
    public MyGlideModule() {
        super();
    }
}