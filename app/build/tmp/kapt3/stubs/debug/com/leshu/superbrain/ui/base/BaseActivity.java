package com.leshu.superbrain.ui.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/9 11:08
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/leshu/superbrain/ui/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "initData", "", "initView", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "setLayoutId", "", "app_debug"})
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract int setLayoutId();
    
    public abstract void initView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState);
    
    public abstract void initData();
    
    public BaseActivity() {
        super();
    }
}