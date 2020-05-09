package com.leshu.superbrain.view.loadpage

import android.app.Activity
import android.view.View
import android.view.ViewGroup

enum class LoadPageStatus {
    Loading, Fail, Empty, NoNet
}

abstract class BasePageStateView {
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
    abstract fun getLoadingView(loadPageView: LoadPageView): View

    /**
     * 布局中的 加载失败布局
     * @return View
     */
    abstract fun getLoadFailView(loadPageView: LoadPageView): View


    /**
     * 布局中的 加载空布局
     * @return View
     */
    abstract fun getLoadEmptyView(loadPageView: LoadPageView): View

    /**
     * 布局中的 加载无网络布局
     * @return View
     */
    abstract fun getLoadNoNetView(loadPageView: LoadPageView): View


    /**
     * 可重写此方式，实行自定义逻辑
     * @param holder BaseViewHolder
     * @param position Int
     * @param loadPageStatus loadPageStatus
     */
    open fun convert(loadPageView: LoadPageView, loadPageStatus: LoadPageStatus) {
        when (loadPageStatus) {

            LoadPageStatus.Loading -> {
                getLoadingView(loadPageView).isVisible(true)
                getLoadFailView(loadPageView).isVisible(false)
                getLoadEmptyView(loadPageView).isVisible(false)
                getLoadNoNetView(loadPageView).isVisible(false)
            }
            LoadPageStatus.Fail -> {
                getLoadingView(loadPageView).isVisible(false)
                getLoadFailView(loadPageView).isVisible(true)
                getLoadEmptyView(loadPageView).isVisible(false)
                getLoadNoNetView(loadPageView).isVisible(false)
            }
            LoadPageStatus.Empty -> {
                getLoadingView(loadPageView).isVisible(false)
                getLoadFailView(loadPageView).isVisible(false)
                getLoadEmptyView(loadPageView).isVisible(true)
                getLoadNoNetView(loadPageView).isVisible(false)
            }
            LoadPageStatus.NoNet -> {
                getLoadingView(loadPageView).isVisible(false)
                getLoadFailView(loadPageView).isVisible(false)
                getLoadEmptyView(loadPageView).isVisible(false)
                getLoadNoNetView(loadPageView).isVisible(true)
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