package com.leshu.superbrain.ui.homepage

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.coder.zzq.smartshow.toast.SmartToast
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.HomePageAdapter
import com.leshu.superbrain.adapter.ImageAdapter
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.view.HomePageHeadView
import com.leshu.superbrain.view.loadpage.*
import com.leshu.superbrain.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.layout_banner.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomePageFragment : BaseVMFragment<MainViewModel>(), OnLoadMoreListener {
    private val homePageAdapter = HomePageAdapter()
    private val loadPageView: BasePageStateView = SimpleLoadPageView()
    private lateinit var rootView: LoadPageView
    override fun providerVMClass(): Class<MainViewModel>? = MainViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_home_page
    override fun initData() {
        refresh()
    }

    override fun initView() {
        rootView = activity?.let { activity -> loadPageView.getRootView(activity) } as LoadPageView
        rootView.failTextView().onClick {
            refresh()
        }

        firstPageRv.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = homePageAdapter
        }
        homePageAdapter.run {
            loadMoreModule.setOnLoadMoreListener(this@HomePageFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            activity?.let { addHeaderView(HomePageHeadView(it)) }
        }
        refreshLayout.setOnRefreshListener {
            refresh()
        }
        refreshLayout.setEnableLoadMore(false)
    }

    private fun refresh() {
        mViewModel.loadHomeArticles(true)
    }

    override fun startObserve() {
        mViewModel.apply {
            mListModel.observe(this@HomePageFragment, Observer {
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    loadPageView.convert(
                        rootView,
                        loadPageStatus = loadPageStatus
                    )
                    homePageAdapter.setEmptyView(rootView)
                }

                it.showSuccess.let { list ->
                    homePageAdapter.run {
                        loadMoreModule.isEnableLoadMore = false
                        if (it.isRefresh) setList(list) else list?.let { list -> addData(list) }
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                        mViewModel.loadBanner()
                    }
                    if (refreshLayout.isRefreshing) refreshLayout.finishRefresh()
                }
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()
                it.showError.let {
                    if (refreshLayout.isRefreshing) refreshLayout.finishRefresh()
                }

            })
            mBanner.observe(this@HomePageFragment, Observer { it1 ->
                banner?.adapter = activity?.let { ImageAdapter(it1, it) }

            })
        }
    }

    override fun onLoadMore() {
        mViewModel.loadHomeArticles(false)
    }

    override fun onStart() {
        super.onStart()
        banner?.start()
    }

    override fun onStop() {
        super.onStop()
        banner?.stop()
    }
}