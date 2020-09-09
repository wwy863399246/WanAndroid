package com.wwy.android.ui.homemine.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.coder.zzq.smartshow.toast.SmartToast
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.adapter.PointsRankAdapter
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.PointRankingViewModel
import kotlinx.android.synthetic.main.activity_my_recycleview.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/17 0017 下午 16:12
 *@描述
 */
class PointRankingActivity : BaseVMActivity<PointRankingViewModel>(), OnLoadMoreListener {
    override fun initVM(): PointRankingViewModel = getViewModel()
    private val pointsRankAdapter = PointsRankAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun setLayoutId(): Int = R.layout.activity_my_recycleview
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
            setLeftTitleNavigationBarText(R.string.integral_ranking)
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        activityRecycleRv.apply {
            adapter = pointsRankAdapter.apply {
                loadMoreModule.setOnLoadMoreListener(this@PointRankingActivity)
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            }
        }
        refreshLayout.apply {
            setOnRefreshListener { refresh() }
            setEnableLoadMore(false)
        }
    }

    private fun refresh() {
        mViewModel.getPointsRank(true)
    }

    override fun initData() {
        refresh()
    }

    override fun startObserve() {
        mViewModel.run {
            mListModel.observe(this@PointRankingActivity, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) pointsRankAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        pointsRankAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    pointsRankAdapter.run {
                        if (it.isRefresh) setList(list) else addData(list)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    pointsRankAdapter.loadMoreModule.loadMoreFail()
                    SmartToast.show(errorMsg)
                }

            })
        }
    }

    override fun onLoadMore() {
        mViewModel.getPointsRank(false)
    }
}