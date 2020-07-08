package com.wwy.android.ui.homesyetem

import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.wwy.android.R
import com.wwy.android.adapter.NavigationAdapter
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.view.loadpage.loadPageViewForStatus
import com.wwy.android.vm.NavigationViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2019/9/25 9:50
 *@描述
 */
class NavigationFragment : BaseVMFragment<NavigationViewModel>() {
    private val navigationAdapter = NavigationAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus = SimplePageViewForStatus()
    private lateinit var rootView: loadPageViewForStatus
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview

    override fun initVM(): NavigationViewModel = getViewModel()
    override fun initView() {
        rootView =
            activity?.let { activity -> loadPageViewForStatus.getRootView(activity) } as loadPageViewForStatus
        rootView.apply {
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
        mViewModel.apply {
            navigationListModel.observe(viewLifecycleOwner, Observer {
                if (!it.isRefresh) refreshLayout.finishRefresh()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    loadPageViewForStatus.convert(rootView, loadPageStatus)
                    navigationAdapter.setEmptyView(rootView)
                }
                it.showSuccess?.let { list ->
                    navigationAdapter.setList(list)
                }
                it.showError?.let { }//加载失败
            })
        }
    }


}