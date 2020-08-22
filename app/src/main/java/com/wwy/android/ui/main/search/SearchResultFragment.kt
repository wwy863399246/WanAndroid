package com.wwy.android.ui.main.search

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.createViewModelLazy
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
import com.wwy.android.vm.SearchViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.koin.androidx.viewmodel.ViewModelParameters
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 下午 23:28
 *@描述
 */
class SearchResultFragment : BaseVMFragment<SearchViewModel>(), OnLoadMoreListener {
    companion object {
        fun newInstance(): SearchResultFragment {
            return SearchResultFragment()
        }
    }

    private val homePageAdapter = HomePageAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus = SimplePageViewForStatus()
    private var rootView: LoadPageViewForStatus? = null
    override fun initVM(): SearchViewModel {
        val viewModel: SearchViewModel by activityViewModels()
        return viewModel
    }


    override fun setLayoutResId(): Int = R.layout.fragment_recycleview

    override fun startObserve() {
        mViewModel.run {
            mListModel.observe(viewLifecycleOwner, Observer {
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


    override fun initView() {
        rootView =
            loadPageViewForStatus.getRootView(activity as SearchActivity) as LoadPageViewForStatus
        rootView?.apply {
            failTextView().onClick { doSearch() }
            noNetTextView().onClick { doSearch() }
        }
        ArticleRv.apply {
            adapter = homePageAdapter
        }
        homePageAdapter.apply {
            loadMoreModule.setOnLoadMoreListener(this@SearchResultFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            setOnItemClickListener { adapter, view, position ->
                val article = data[position]
                startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
            }
        }
        refreshLayout.run {
            setOnRefreshListener { doSearch() }
            setEnableLoadMore(false)
        }
    }

    override fun initData() {
    }

    private fun doSearch() {
        mViewModel.search(true)
    }

    override fun onLoadMore() {
        mViewModel.search(false)
    }

}