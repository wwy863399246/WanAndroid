package com.wwy.android.ui.homemine.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.coder.zzq.smartshow.toast.SmartToast
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.MyCollectAndShareViewModel
import kotlinx.android.synthetic.main.activity_my_recycleview.*
import kotlinx.android.synthetic.main.activity_my_theme.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/15 0015 下午 21:26
 *@描述
 */
class MyCollectListActivity : BaseVMActivity<MyCollectAndShareViewModel>(), OnLoadMoreListener {
    private val homePageAdapter = HomePageAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun initVM(): MyCollectAndShareViewModel = getViewModel()
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
            setLeftTitleNavigationBarText(R.string.my_collect)
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        refreshLayout.apply {
            setOnRefreshListener { refresh() }
            setEnableLoadMore(false)
        }
        activityRecycleRv.apply {
            adapter = homePageAdapter.apply {
                loadMoreModule.setOnLoadMoreListener(this@MyCollectListActivity)
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
                setOnItemClickListener { adapter, view, position ->
                    val article = data[position]
                    startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
                }
            }
        }
    }

    override fun initData() {
        refresh()
    }

    override fun startObserve() {
        mViewModel.run {
            mListModel.observe(this@MyCollectListActivity, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        homePageAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    homePageAdapter.run {
                        if (it.isRefresh) setList(list) else addData(list)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    homePageAdapter.loadMoreModule.loadMoreFail()
                    SmartToast.show(errorMsg)
                }

            })
        }
    }

    private fun refresh() {
        mViewModel.getCollectList(true)
    }

    override fun onLoadMore() {
        mViewModel.getCollectList(false)
    }
}