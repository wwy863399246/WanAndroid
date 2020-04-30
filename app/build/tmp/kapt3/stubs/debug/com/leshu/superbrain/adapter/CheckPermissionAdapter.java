package com.leshu.superbrain.adapter;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/10 11:36
 * @描述 权限
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/leshu/superbrain/adapter/CheckPermissionAdapter;", "Lcom/qw/soul/permission/callbcak/CheckRequestPermissionListener;", "()V", "onPermissionDenied", "", "permission", "Lcom/qw/soul/permission/bean/Permission;", "app_debug"})
public abstract class CheckPermissionAdapter implements com.qw.soul.permission.callbcak.CheckRequestPermissionListener {
    
    @java.lang.Override()
    public void onPermissionDenied(@org.jetbrains.annotations.Nullable()
    com.qw.soul.permission.bean.Permission permission) {
    }
    
    public CheckPermissionAdapter() {
        super();
    }
}