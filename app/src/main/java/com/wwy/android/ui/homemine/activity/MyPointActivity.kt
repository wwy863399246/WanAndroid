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
import com.wwy.android.adapter.MinePointsAdapter
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.PointViewModel
import kotlinx.android.synthetic.main.activity_my_recycleview.*
import kotlinx.android.synthetic.main.header_mine_points.view.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/15 0015 下午 14:47
 *@描述
 */
class MyPointActivity : BaseVMActivity<PointViewModel>(), OnLoadMoreListener {
    override fun initVM(): PointViewModel = getViewModel()
    private val minePointsAdapter = MinePointsAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    private lateinit var mHeaderView: View
    override fun setLayoutId(): Int = R.layout.activity_my_recycleview
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.activityRecycleNv)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        mHeaderView = LayoutInflater.from(this).inflate(R.layout.header_mine_points, null)
        rootView = (loadPageViewForStatus.getRootView(this) as LoadPageViewForStatus).apply {
            failTextView().onClick { refresh() }
            noNetTextView().onClick { refresh() }
        }
        activityRecycleNv.apply {
            setLeftTitleNavigationBarText(R.string.my_integral)
            ivRightNavigationBarOne.clickWithTrigger {
                startActivity<ShareActivity>()
            }
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        activityRecycleRv.apply {
            adapter = minePointsAdapter.apply {
                loadMoreModule.setOnLoadMoreListener(this@MyPointActivity)
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
                if (headerLayoutCount == 0) setHeaderView(mHeaderView)
            }
        }
        refreshLayout.apply {
            setOnRefreshListener { refresh() }
            setEnableLoadMore(false)
        }
    }

    private fun refresh() {
        mViewModel.getPointsRecord(true)
    }

    override fun initData() {
        refresh()
    }

    override fun startObserve() {
        mViewModel.run {
            mPointLiveData.observe(this@MyPointActivity, Observer {
                mHeaderView.tvTotalPoints.text = it.coinCount.toString()
                mHeaderView.tvLevelRank.text = getString(R.string.level_rank, it.level, it.rank)
            })
            mListModel.observe(this@MyPointActivity, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) minePointsAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        minePointsAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    minePointsAdapter.run {
                        if (it.isRefresh) setList(list) else addData(list)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    minePointsAdapter.loadMoreModule.loadMoreFail()
                    SmartToast.show(errorMsg)
                }

            })
        }
    }

    override fun onLoadMore() {
        mViewModel.getPointsRecord(false)
    }

}