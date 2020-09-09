package com.wwy.android.ui.homeplaza

import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.coder.zzq.smartshow.toast.SmartToast
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.HomePlazaViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/6/1 11:35
 *@描述 广场
 */
class HomePlazaFragment : BaseVMFragment<HomePlazaViewModel>(), OnLoadMoreListener {
    private val homePageAdapter = HomePageAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun initVM(): HomePlazaViewModel = getViewModel()

    override fun setLayoutResId(): Int = R.layout.fragment_recycleview

    override fun initView() {
        rootView =
            (loadPageViewForStatus.getRootView(activity as MainActivity) as LoadPageViewForStatus).apply {
                failTextView().onClick { refresh() }
                noNetTextView().onClick { refresh() }
            }

        ArticleRv.apply {
            adapter = homePageAdapter
        }
        homePageAdapter.apply {
            loadMoreModule.setOnLoadMoreListener(this@HomePlazaFragment)
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

    private fun refresh() {
        mViewModel.loadSquareArticleList(true)
    }

    override fun initData() {
        refresh()
    }

    override fun startObserve() {
        mViewModel.run {
            mHomePlazaListModel.observe(this@HomePlazaFragment, Observer {
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
                    homePageAdapter.run {
                        loadMoreModule.isEnableLoadMore = false
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

    override fun onLoadMore() {
        mViewModel.loadSquareArticleList(false)
    }


}