package com.wwy.android.ui.homesyetem

import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.wwy.android.R
import com.wwy.android.adapter.NavigationAdapter
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.vm.NavigationViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2019/9/25 9:50
 *@描述
 */
class NavigationFragment : BaseVMFragment<NavigationViewModel>() {
    private val navigationAdapter = NavigationAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus = SimplePageViewForStatus()
    private var rootView: LoadPageViewForStatus? = null
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview

    override fun initVM(): NavigationViewModel = getViewModel()
    override fun initView() {
        rootView =
            loadPageViewForStatus.getRootView(activity as MainActivity) as LoadPageViewForStatus
        rootView?.apply {
            failTextView().onClick { initData() }
        }
        ArticleRv.apply {
            //  addItemDecoration(SpacesItemDecoration(dip(8), LinearLayoutManager.VERTICAL))
            adapter = navigationAdapter
        }
        navigationAdapter.apply {
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            registerListener {
                onTypeTextClick { tag, position ->
                    val articles = data[position].articles
                    startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to articles[tag])
                }
            }
        }
        refreshLayout.setOnRefreshListener { initData() }
        refreshLayout.setEnableLoadMore(false)
    }

    override fun initData() {
        mViewModel.getNavigationData()
    }


    override fun startObserve() {
        mViewModel.run {
            navigationListModel.observe(viewLifecycleOwner, Observer {
                if (!it.isRefresh) refreshLayout.finishRefresh()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(
                            rootView, loadPageStatus
                        )
                        navigationAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    navigationAdapter.setList(list)
                }
                it.showError?.let { }//加载失败
            })
        }
    }


}