package com.wwy.android.view.loadpage

import android.app.Activity
import android.view.View

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
    abstract fun getLoadingView(loadPageViewForStatus: loadPageViewForStatus): View

    /**
     * 布局中的 加载失败布局
     * @return View
     */
    abstract fun getLoadFailView(loadPageViewForStatus: loadPageViewForStatus): View


    /**
     * 布局中的 加载空布局
     * @return View
     */
    abstract fun getLoadEmptyView(loadPageViewForStatus: loadPageViewForStatus): View

    /**
     * 布局中的 加载无网络布局
     * @return View
     */
    abstract fun getLoadNoNetView(loadPageViewForStatus: loadPageViewForStatus): View


    /**
     * 可重写此方式，实行自定义逻辑
     * @param holder BaseViewHolder
     * @param position Int
     * @param loadPageStatus loadPageStatus
     */
    open fun convert(loadPageViewForStatus: loadPageViewForStatus, loadPageStatus: LoadPageStatus) {
        when (loadPageStatus) {

            LoadPageStatus.Loading -> {
                getLoadingView(loadPageViewForStatus).isVisible(true)
                getLoadFailView(loadPageViewForStatus).isVisible(false)
                getLoadEmptyView(loadPageViewForStatus).isVisible(false)
                getLoadNoNetView(loadPageViewForStatus).isVisible(false)
            }
            LoadPageStatus.Fail -> {
                getLoadingView(loadPageViewForStatus).isVisible(false)
                getLoadFailView(loadPageViewForStatus).isVisible(true)
                getLoadEmptyView(loadPageViewForStatus).isVisible(false)
                getLoadNoNetView(loadPageViewForStatus).isVisible(false)
            }
            LoadPageStatus.Empty -> {
                getLoadingView(loadPageViewForStatus).isVisible(false)
                getLoadFailView(loadPageViewForStatus).isVisible(false)
                getLoadEmptyView(loadPageViewForStatus).isVisible(true)
                getLoadNoNetView(loadPageViewForStatus).isVisible(false)
            }
            LoadPageStatus.NoNet -> {
                getLoadingView(loadPageViewForStatus).isVisible(false)
                getLoadFailView(loadPageViewForStatus).isVisible(false)
                getLoadEmptyView(loadPageViewForStatus).isVisible(false)
                getLoadNoNetView(loadPageViewForStatus).isVisible(true)
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