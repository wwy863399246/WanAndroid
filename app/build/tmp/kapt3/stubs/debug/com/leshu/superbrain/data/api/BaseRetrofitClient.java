package com.leshu.superbrain.data.api;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/10/8 15:13
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H$R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/leshu/superbrain/data/api/BaseRetrofitClient;", "", "()V", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "mLoggingInterceptor", "Lokhttp3/Interceptor;", "getService", "S", "serviceClass", "Ljava/lang/Class;", "hostType", "", "(Ljava/lang/Class;I)Ljava/lang/Object;", "handleBuilder", "", "builder", "Lokhttp3/OkHttpClient$Builder;", "Companion", "app_debug"})
public abstract class BaseRetrofitClient {
    @android.annotation.SuppressLint(value = {"BinaryOperationInTimber"})
    private final okhttp3.Interceptor mLoggingInterceptor = null;
    private static final int TIME_OUT = 5;
    public static final com.leshu.superbrain.data.api.BaseRetrofitClient.Companion Companion = null;
    
    private final okhttp3.OkHttpClient getClient() {
        return null;
    }
    
    protected abstract void handleBuilder(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient.Builder builder);
    
    public final <S extends java.lang.Object>S getService(@org.jetbrains.annotations.NotNull()
    java.lang.Class<S> serviceClass, int hostType) {
        return null;
    }
    
    public BaseRetrofitClient() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/leshu/superbrain/data/api/BaseRetrofitClient$Companion;", "", "()V", "TIME_OUT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}