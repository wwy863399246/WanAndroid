package com.leshu.superbrain.ui.homepage;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/11/12 9:31
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001aR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/leshu/superbrain/ui/homepage/ProjectViewModel;", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "()V", "articleUserCase", "Lcom/leshu/superbrain/data/repository/ArticleUserCase;", "getArticleUserCase", "()Lcom/leshu/superbrain/data/repository/ArticleUserCase;", "articleUserCase$delegate", "Lkotlin/Lazy;", "mMainProjectListModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/leshu/superbrain/util/ListModel;", "Lcom/leshu/superbrain/data/bean/ClassifyResponse;", "getMMainProjectListModel", "()Landroidx/lifecycle/MutableLiveData;", "mProjectListModel", "Lcom/leshu/superbrain/data/bean/Article;", "getMProjectListModel", "mProjectLoadPageStatus", "Lcom/leshu/superbrain/view/loadpage/LoadPageStatus;", "projectRepository", "Lcom/leshu/superbrain/data/repository/ProjectRepository;", "getProjectRepository", "()Lcom/leshu/superbrain/data/repository/ProjectRepository;", "projectRepository$delegate", "loadProjectArticles", "Lkotlinx/coroutines/Job;", "isRefresh", "", "cid", "", "loadProjectClassify", "app_debug"})
public final class ProjectViewModel extends com.leshu.superbrain.vm.base.BaseViewModel {
    private final kotlin.Lazy projectRepository$delegate = null;
    private final kotlin.Lazy articleUserCase$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.ClassifyResponse>> mMainProjectListModel = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> mProjectListModel = null;
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.view.loadpage.LoadPageStatus> mProjectLoadPageStatus = null;
    
    private final com.leshu.superbrain.data.repository.ProjectRepository getProjectRepository() {
        return null;
    }
    
    private final com.leshu.superbrain.data.repository.ArticleUserCase getArticleUserCase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.ClassifyResponse>> getMMainProjectListModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.Article>> getMProjectListModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadProjectClassify() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadProjectArticles(boolean isRefresh, int cid) {
        return null;
    }
    
    public ProjectViewModel() {
        super();
    }
}