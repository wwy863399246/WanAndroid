package com.wwy.android.ui.homepage

import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.coder.zzq.smartshow.toast.SmartToast
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.adapter.ImageAdapter
import com.wwy.android.data.bean.Article
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.view.HomePageHeadView
import com.wwy.android.view.loadpage.*
import com.wwy.android.vm.HomePageViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import kotlinx.android.synthetic.main.layout_banner.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomePageFragment : BaseVMFragment<HomePageViewModel>(), OnLoadMoreListener {
    private val homePageAdapter = HomePageAdapter()
    private val homePageStickAdapter = HomePageStickAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    private lateinit var homePageHeadView: HomePageHeadView
    override fun initVM(): HomePageViewModel = getViewModel()
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    override fun initData() {
        refresh()
    }

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
            homePageHeadView = HomePageHeadView(activity, homePageStickAdapter)
            loadMoreModule.setOnLoadMoreListener(this@HomePageFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            activity?.let { addHeaderView(homePageHeadView) }
            setOnItemClickListener { adapter, view, position ->
                val article = data[position]
                startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
            }
        }
        refreshLayout.setOnRefreshListener { refresh() }
        refreshLayout.setEnableLoadMore(false)
    }

    private fun refresh() {
        mViewModel.loadHomeArticles(true)
    }

    override fun startObserve() {
        mViewModel.run {
            mListModel.observe(this@HomePageFragment, Observer {
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
                        if (it.isRefresh) setList(list) else addData(list)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                        mViewModel.loadBanner() //列表加载成功后再加载banner
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    homePageAdapter.loadMoreModule.loadMoreFail()
                    SmartToast.show(errorMsg)
                }

            })
            mBanner.observe(this@HomePageFragment, Observer { it1 ->
                banner?.adapter = activity?.let { ImageAdapter(it1, it) }
                mViewModel.loadStickArticles()
            })
            mStickArticles.observe(this@HomePageFragment, Observer {
                homePageStickAdapter.setList(it)
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

    class HomePageStickAdapter :
        BaseQuickAdapter<Article, BaseViewHolder>(R.layout.layout_stick_article) {

        override fun convert(holder: BaseViewHolder, item: Article) {
            item.let {
                holder.setText(R.id.tvStickContent, it.title)
                if ((data.size - 1) == holder.layoutPosition) holder.setVisible(
                    R.id.viewDivision,
                    false
                )
            }
        }
    }

}