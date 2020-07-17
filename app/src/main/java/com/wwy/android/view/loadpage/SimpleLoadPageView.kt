package com.wwy.android.view.loadpage

import android.app.Activity
import android.view.View


class SimplePageViewForStatus : BasePageViewForStatus() {
    override fun getRootView(activity: Activity): LoadPageViewForStatus = LoadPageViewForStatus(activity)
    override fun getLoadingView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.progressBarView()

    override fun getLoadFailView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.failTextView()

    override fun getLoadEmptyView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.emptyTextView()

    override fun getLoadNoNetView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.noNetTextView()
}