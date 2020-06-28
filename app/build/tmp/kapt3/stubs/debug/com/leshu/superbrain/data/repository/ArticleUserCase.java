package com.leshu.superbrain.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JQ\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014JG\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u0013\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J?\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J?\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J?\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018JG\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u0013\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J?\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018JG\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u0013\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase;", "", "remoteDataSource", "Lcom/leshu/superbrain/data/repository/datasource/RemoteDataSource;", "(Lcom/leshu/superbrain/data/repository/datasource/RemoteDataSource;)V", "currentPage", "", "getArticleList", "", "articleType", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "isRefresh", "", "listModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/leshu/superbrain/util/ListModel;", "Lcom/leshu/superbrain/data/bean/Article;", "loadPageStatus", "Lcom/leshu/superbrain/view/loadpage/LoadPageStatus;", "cid", "(Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBlogArticleList", "(ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCollectArticleList", "(ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeArticleList", "getLatestProjectList", "getProjectTypeDetailList", "getSquareArticleList", "getSystemTypeArticleList", "ArticleType", "app_debug"})
public final class ArticleUserCase {
    private int currentPage = 0;
    private final com.leshu.superbrain.data.repository.datasource.RemoteDataSource remoteDataSource = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHomeArticleList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSquareArticleList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLatestProjectList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProjectTypeDetailList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, int cid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCollectArticleList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSystemTypeArticleList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, int cid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getBlogArticleList(boolean isRefresh, @org.jetbrains.annotations.Nullable()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> listModel, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> loadPageStatus, int cid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p4) {
        return null;
    }
    
    public ArticleUserCase(@org.jetbrains.annotations.NotNull()
    com.leshu.superbrain.data.repository.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "", "()V", "Blog", "Collection", "Home", "LatestProject", "ProjectDetailList", "Square", "SystemType", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Home;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Square;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$LatestProject;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$ProjectDetailList;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Collection;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$SystemType;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Blog;", "app_debug"})
    public static abstract class ArticleType {
        
        private ArticleType() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Home;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class Home extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.Home INSTANCE = null;
            
            private Home() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Square;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class Square extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.Square INSTANCE = null;
            
            private Square() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$LatestProject;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class LatestProject extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.LatestProject INSTANCE = null;
            
            private LatestProject() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$ProjectDetailList;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class ProjectDetailList extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.ProjectDetailList INSTANCE = null;
            
            private ProjectDetailList() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Collection;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class Collection extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.Collection INSTANCE = null;
            
            private Collection() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$SystemType;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class SystemType extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.SystemType INSTANCE = null;
            
            private SystemType() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType$Blog;", "Lcom/leshu/superbrain/data/repository/ArticleUserCase$ArticleType;", "()V", "app_debug"})
        public static final class Blog extends com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType {
            public static final com.leshu.superbrain.data.repository.ArticleUserCase.ArticleType.Blog INSTANCE = null;
            
            private Blog() {
                super();
            }
        }
    }
}