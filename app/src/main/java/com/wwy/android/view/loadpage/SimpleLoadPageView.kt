package com.wwy.android.view.loadpage

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment

/**
可以自己定义列表加载界面（xml也可）
override fun getRootView(parent: ViewGroup): View =
parent.getItemView(R.layout.brvah_quick_view_load_more)

override fun getLoadingView(holder: BaseViewHolder): View =
holder.getView(R.id.load_more_loading_view)

override fun getLoadComplete(holder: BaseViewHolder): View =
holder.getView(R.id.load_more_load_complete_view)

override fun getLoadEndView(holder: BaseViewHolder): View =
holder.getView(R.id.load_more_load_end_view)

override fun getLoadFailView(holder: BaseViewHolder): View =
holder.getView(R.id.load_more_load_fail_view)
 */
class SimplePageViewForStatus : BasePageViewForStatus() {
    override fun getRootView(activity: Activity): LoadPageViewForStatus =
        LoadPageViewForStatus(activity)

    override fun getLoadingView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.progressBarView()

    override fun getLoadFailView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.failTextView()

    override fun getLoadEmptyView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.emptyTextView()

    override fun getLoadNoNetView(LoadPageViewForStatus: LoadPageViewForStatus): View =
        LoadPageViewForStatus.noNetTextView()
}