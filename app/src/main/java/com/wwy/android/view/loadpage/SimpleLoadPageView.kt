package com.wwy.android.view.loadpage

import android.app.Activity
import android.view.View


class SimplePageViewForStatus : BasePageViewForStatus() {
    override fun getRootView(activity: Activity): loadPageViewForStatus = loadPageViewForStatus(activity)
    override fun getLoadingView(loadPageViewForStatus: loadPageViewForStatus): View =
        loadPageViewForStatus.progressBarView()

    override fun getLoadFailView(loadPageViewForStatus: loadPageViewForStatus): View =
        loadPageViewForStatus.failTextView()

    override fun getLoadEmptyView(loadPageViewForStatus: loadPageViewForStatus): View =
        loadPageViewForStatus.emptyTextView()

    override fun getLoadNoNetView(loadPageViewForStatus: loadPageViewForStatus): View =
        loadPageViewForStatus.noNetTextView()
}