package com.wwy.android.ui.homesyetem

import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.coder.zzq.smartshow.toast.SmartToast
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.adapter.SystemAdapter
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.SystemViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2019/9/25 9:46
 *@描述 体系
 */
class SystemFragment : BaseVMFragment<SystemViewModel>() {
    private val systemAdapter = SystemAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus = SimplePageViewForStatus()
    private lateinit var rootView: LoadPageViewForStatus
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    override fun initVM(): SystemViewModel = getViewModel()

    override fun initData() {
        mViewModel.getSystemType()
    }

    override fun initView() {
        rootView =
            activity?.let { activity -> loadPageViewForStatus.getRootView(activity) } as LoadPageViewForStatus
        rootView.apply {
            failTextView().onClick { initData() }
        }

        ArticleRv.apply {
            //  addItemDecoration(SpacesItemDecoration(dip(8), LinearLayoutManager.VERTICAL))
            adapter = systemAdapter
        }
        systemAdapter.apply {
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
            registerListener {
                onTypeTextClick {
                    LiveEventBus.get("theme").post(R.style.AppTheme_Orange)
                }
            }
        }
        refreshLayout.setOnRefreshListener { initData() }
        refreshLayout.setEnableLoadMore(false)
    }


    override fun startObserve() {
        mViewModel.apply {
            systemClassifyListModel.observe(this@SystemFragment, Observer {
                if (!it.isRefresh) refreshLayout.finishRefresh()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    loadPageViewForStatus.convert(rootView, loadPageStatus)
                    systemAdapter.setEmptyView(rootView)
                }
                it.showSuccess?.let { list ->
                    systemAdapter.setList(list)
                }
                it.showError?.let { }//加载失败
            })
        }
    }
}