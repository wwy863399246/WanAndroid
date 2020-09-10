package com.wwy.android.ui.homesyetem

import android.os.Bundle
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.SystemViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/20 0020 下午 16:20
 *@描述
 */
class SystemTypeFragment : BaseVMFragment<SystemViewModel>(), OnLoadMoreListener {
    override fun initVM(): SystemViewModel = getViewModel()
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    private val cid by lazy { arguments?.getInt(CID) }
    private val homePageAdapter = HomePageAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    private var i: Int = 0

    companion object {
        private const val CID = "projectCid"
        fun newInstance(cid: Int): SystemTypeFragment {
            val fragment = SystemTypeFragment()
            val bundle = Bundle()
            bundle.putInt(CID, cid)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
        rootView =
            (loadPageViewForStatus.getRootView(activity as SystemActivity) as LoadPageViewForStatus).apply {
                failTextView().onClick { refresh() }
                noNetTextView().onClick { refresh() }
            }
        ArticleRv.apply {
            adapter = homePageAdapter
        }
        homePageAdapter.apply {
            loadMoreModule.setOnLoadMoreListener(this@SystemTypeFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            setOnItemClickListener { adapter, view, position ->
                val article = data[position]
                startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
            }
        }
        refreshLayout.setOnRefreshListener { refresh() }
        refreshLayout.setEnableLoadMore(false)
    }

    override fun startObserve() {
        mViewModel.run {
            mSystemListModel.observe(this@SystemTypeFragment, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(
                            rootView,
                            loadPageStatus = loadPageStatus
                        )
                        homePageAdapter.setEmptyView(rootView)
                    }

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
        if (i != 0) homePageAdapter.setList(null) //viewpage缓存4个页面 页面重新加载的时候清空数据重新获取
        refresh()
        i++
    }

    private fun refresh() {
        homePageAdapter.loadMoreModule.isEnableLoadMore = false
        cid?.let { mViewModel.loadSystemArticles(true, it) }
    }

    override fun onLoadMore() {
        cid?.let { mViewModel.loadSystemArticles(false, it) }
    }

}