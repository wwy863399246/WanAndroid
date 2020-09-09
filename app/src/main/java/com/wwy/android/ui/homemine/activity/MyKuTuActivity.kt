package com.wwy.android.ui.homemine.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.chad.library.adapter.base.module.LoadMoreModule
import com.coder.zzq.smartshow.toast.SmartToast
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.adapter.KuTuAdapter
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.color
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.KuTuViewModel
import kotlinx.android.synthetic.main.activity_my_recycleview.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/19 0019 下午 22:28
 *@描述
 */
class MyKuTuActivity : BaseVMActivity<KuTuViewModel>(), OnLoadMoreListener {
    override fun initVM(): KuTuViewModel = getViewModel()
    override fun setLayoutId(): Int = R.layout.activity_my_recycleview
    private val kuTuAdapter = KuTuAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.activityRecycleNv)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        rootView = (loadPageViewForStatus.getRootView(this) as LoadPageViewForStatus).apply {
            failTextView().onClick { refresh() }
            noNetTextView().onClick { refresh() }
        }
        activityRecycleNv.apply {
            setLeftTitleNavigationBarText(R.string.my_ku_tu)
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        refreshLayout.apply {
            setOnRefreshListener { refresh() }
            setEnableLoadMore(false)
        }
        activityRecycleRv.apply {
            layoutManager = GridLayoutManager(this@MyKuTuActivity, 2)
            backgroundColor = color(R.color.color_page_bg)
            adapter = kuTuAdapter.apply {
                loadMoreModule.setOnLoadMoreListener(this@MyKuTuActivity)
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            }
        }
    }

    private fun refresh() {
        mViewModel.getMeiZi(true)
    }

    override fun startObserve() {
        mViewModel.run {
            mListModel.observe(this@MyKuTuActivity, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) kuTuAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        kuTuAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    kuTuAdapter.run {
                        if (it.isRefresh) setList(list) else addData(list)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    kuTuAdapter.loadMoreModule.loadMoreFail()
                    SmartToast.show(errorMsg)
                }

            })
        }
    }

    override fun initData() {
        refresh()
    }

    override fun onLoadMore() {
        mViewModel.getMeiZi(false)
    }
}