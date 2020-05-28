package com.leshu.superbrain.ui.homepage;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/11/12 9:31
 * @描述
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/leshu/superbrain/ui/homepage/ProjectViewModel;", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "()V", "mListModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/leshu/superbrain/util/ListModel;", "Lcom/leshu/superbrain/data/bean/ClassifyResponse;", "getMListModel", "()Landroidx/lifecycle/MutableLiveData;", "projectRepository", "Lcom/leshu/superbrain/data/repository/ProjectRepository;", "getProjectRepository", "()Lcom/leshu/superbrain/data/repository/ProjectRepository;", "projectRepository$delegate", "Lkotlin/Lazy;", "loadProjectClassify", "Lkotlinx/coroutines/Job;", "app_debug"})
public final class ProjectViewModel extends com.leshu.superbrain.vm.base.BaseViewModel {
    private final kotlin.Lazy projectRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.ClassifyResponse>> mListModel = null;
    
    private final com.leshu.superbrain.data.repository.ProjectRepository getProjectRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.leshu.superbrain.util.ListModel<com.leshu.superbrain.data.bean.ClassifyResponse>> getMListModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job loadProjectClassify() {
        return null;
    }
    
    public ProjectViewModel() {
        super();
    }
}