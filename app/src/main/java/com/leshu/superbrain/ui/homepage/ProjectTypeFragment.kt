package com.leshu.superbrain.ui.homepage

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.HomePageAdapter
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.view.loadpage.BasePageViewForStatus
import com.leshu.superbrain.view.loadpage.loadPageViewForStatus
import com.leshu.superbrain.view.loadpage.SimplePageViewForStatus
import com.leshu.superbrain.vm.HomeProjectViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ProjectTypeFragment : BaseVMFragment<HomeProjectViewModel>(), OnLoadMoreListener {
    override fun initVM(): HomeProjectViewModel = getViewModel()
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    private val cid by lazy { arguments?.getInt(CID) }// cid==0是最新项目 否项目分类
    private val homePageAdapter = HomePageAdapter()
    private val loadPageViewForStatus : BasePageViewForStatus = SimplePageViewForStatus()
    private lateinit var rootView: loadPageViewForStatus
    private var i: Int = 0

    companion object {
        private const val CID = "projectCid"
        fun newInstance(cid: Int): ProjectTypeFragment {
            val fragment = ProjectTypeFragment()
            val bundle = Bundle()
            bundle.putInt(CID, cid)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
        rootView = activity?.let { activity -> loadPageViewForStatus.getRootView(activity) } as loadPageViewForStatus
        rootView.apply {
            failTextView().onClick { refresh() }
            noNetTextView().onClick { refresh() }
        }

        ArticleRv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = homePageAdapter
        }
        homePageAdapter.apply {
            loadMoreModule.setOnLoadMoreListener(this@ProjectTypeFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
        }
        refreshLayout.setOnRefreshListener { refresh() }
        refreshLayout.setEnableLoadMore(false)
    }

    override fun startObserve() {
        mViewModel.apply {
            mProjectListModel.observe(this@ProjectTypeFragment, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    loadPageViewForStatus.convert(
                        rootView,
                        loadPageStatus = loadPageStatus
                    )
                    homePageAdapter.setEmptyView(rootView)
                }
                it.showSuccess?.let { list ->
                    homePageAdapter.apply {
                        loadMoreModule.isEnableLoadMore = false
                        if (it.isRefresh) setList(list) else addData(list)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    homePageAdapter.loadMoreModule.loadMoreFail()
                }
            })
        }
    }

    override fun initData() {
        if (i != 0) homePageAdapter.setList(null) //viewpge缓存4个界面 界面重新加载的时候清空数据重新获取
        refresh()
        i++
    }

    private fun refresh() {
        homePageAdapter.loadMoreModule.isEnableLoadMore = false
        cid?.let { mViewModel.loadProjectArticles(true, it) }
    }

    override fun onLoadMore() {
        cid?.let { mViewModel.loadProjectArticles(false, it) }
    }


}