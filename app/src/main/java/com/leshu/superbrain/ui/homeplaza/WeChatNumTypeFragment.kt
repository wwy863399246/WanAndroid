package com.leshu.superbrain.ui.homeplaza

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.HomePageAdapter
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.view.loadpage.BasePageStateView
import com.leshu.superbrain.view.loadpage.LoadPageView
import com.leshu.superbrain.view.loadpage.SimpleLoadPageView
import com.leshu.superbrain.vm.WeChatNumViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.androidx.viewmodel.ext.android.getViewModel

class WeChatNumTypeFragment : BaseVMFragment<WeChatNumViewModel>(), OnLoadMoreListener {
    override fun initVM(): WeChatNumViewModel = getViewModel()
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    private val cid by lazy { arguments?.getInt(CID) }
    private val homePageAdapter = HomePageAdapter()
    private val loadPageView : BasePageStateView = SimpleLoadPageView()
    private lateinit var rootView: LoadPageView
    private var i: Int = 0

    companion object {
        private const val CID = "blogCid"
        fun newInstance(cid: Int): WeChatNumTypeFragment {
            val fragment = WeChatNumTypeFragment()
            val bundle = Bundle()
            bundle.putInt(CID, cid)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
        rootView = activity?.let { activity -> loadPageView.getRootView(activity) } as LoadPageView
        rootView.apply {
            failTextView().onClick { refresh() }
            noNetTextView().onClick { refresh() }
        }

        ArticleRv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = homePageAdapter
        }
        homePageAdapter.apply {
            loadMoreModule.setOnLoadMoreListener(this@WeChatNumTypeFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
        }
        refreshLayout.setOnRefreshListener { refresh() }
        refreshLayout.setEnableLoadMore(false)
    }

    override fun startObserve() {
        mViewModel.apply {
            mBlogDataByTypeModel.observe(this@WeChatNumTypeFragment, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    loadPageView.convert(
                        rootView,
                        loadPageStatus = loadPageStatus
                    )
                    homePageAdapter.setEmptyView(rootView)
                }
                it.showSuccess?.let { list ->
                    homePageAdapter.apply {
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
        cid?.let { mViewModel.loadBlogDataByType(true, it) }
    }

    override fun onLoadMore() {
        cid?.let { mViewModel.loadBlogDataByType(false, it) }
    }


}