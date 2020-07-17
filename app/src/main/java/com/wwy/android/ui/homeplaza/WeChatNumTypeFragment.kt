package com.wwy.android.ui.homeplaza

import android.os.Bundle
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.WeChatNumViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.androidx.viewmodel.ext.android.getViewModel

class WeChatNumTypeFragment : BaseVMFragment<WeChatNumViewModel>(), OnLoadMoreListener {
    override fun initVM(): WeChatNumViewModel = getViewModel()
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    private val cid by lazy { arguments?.getInt(CID) }
    private val homePageAdapter = HomePageAdapter()
    private val loadPageViewForStatus : BasePageViewForStatus = SimplePageViewForStatus()
    private lateinit var rootView: LoadPageViewForStatus
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
        rootView = activity?.let { activity -> loadPageViewForStatus.getRootView(activity) } as LoadPageViewForStatus
        rootView.apply {
            failTextView().onClick { refresh() }
            noNetTextView().onClick { refresh() }
        }

        ArticleRv.apply {
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
                    loadPageViewForStatus.convert(
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