package com.wwy.android.view.loadpage

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment

enum class LoadPageStatus {
    Loading, Fail, Empty, NoNet
}

abstract class BasePageViewForStatus {
    /**
     * 根布局
     * @param parent ViewGroup
     * @return View
     */
    abstract fun getRootView(activity: Activity): View

    /**
     * 布局中的 加载更多视图
     * @return View
     */
    abstract fun getLoadingView(LoadPageViewForStatus: LoadPageViewForStatus): View

    /**
     * 布局中的 加载失败布局
     * @return View
     */
    abstract fun getLoadFailView(LoadPageViewForStatus: LoadPageViewForStatus): View


    /**
     * 布局中的 加载空布局
     * @return View
     */
    abstract fun getLoadEmptyView(LoadPageViewForStatus: LoadPageViewForStatus): View

    /**
     * 布局中的 加载无网络布局
     * @return View
     */
    abstract fun getLoadNoNetView(LoadPageViewForStatus: LoadPageViewForStatus): View


    /**
     * 可重写此方式，实行自定义逻辑
     * @param holder BaseViewHolder
     * @param position Int
     * @param loadPageStatus loadPageStatus
     */
    open fun convert(LoadPageViewForStatus: LoadPageViewForStatus, loadPageStatus: LoadPageStatus) {
        when (loadPageStatus) {

            LoadPageStatus.Loading -> {
                getLoadingView(LoadPageViewForStatus).isVisible(true)
                getLoadFailView(LoadPageViewForStatus).isVisible(false)
                getLoadEmptyView(LoadPageViewForStatus).isVisible(false)
                getLoadNoNetView(LoadPageViewForStatus).isVisible(false)
            }
            LoadPageStatus.Fail -> {
                getLoadingView(LoadPageViewForStatus).isVisible(false)
                getLoadFailView(LoadPageViewForStatus).isVisible(true)
                getLoadEmptyView(LoadPageViewForStatus).isVisible(false)
                getLoadNoNetView(LoadPageViewForStatus).isVisible(false)
            }
            LoadPageStatus.Empty -> {
                getLoadingView(LoadPageViewForStatus).isVisible(false)
                getLoadFailView(LoadPageViewForStatus).isVisible(false)
                getLoadEmptyView(LoadPageViewForStatus).isVisible(true)
                getLoadNoNetView(LoadPageViewForStatus).isVisible(false)
            }
            LoadPageStatus.NoNet -> {
                getLoadingView(LoadPageViewForStatus).isVisible(false)
                getLoadFailView(LoadPageViewForStatus).isVisible(false)
                getLoadEmptyView(LoadPageViewForStatus).isVisible(false)
                getLoadNoNetView(LoadPageViewForStatus).isVisible(true)
            }
        }
    }

    private fun View.isVisible(visible: Boolean) {
        this.visibility = if (visible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}