package com.leshu.superbrain.view.loadpage

import android.app.Activity
import android.view.View


class SimpleLoadPageView : BasePageStateView() {
    override fun getRootView(activity: Activity): LoadPageView = LoadPageView(activity)
    override fun getLoadingView(loadPageView: LoadPageView): View =
        loadPageView.progressBarView()

    override fun getLoadFailView(loadPageView: LoadPageView): View =
        loadPageView.failTextView()

    override fun getLoadEmptyView(loadPageView: LoadPageView): View =
        loadPageView.emptyTextView()

    override fun getLoadNoNetView(loadPageView: LoadPageView): View =
        loadPageView.noNetTextView()
}