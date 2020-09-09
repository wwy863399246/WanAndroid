package com.wwy.android.ui.homesyetem

import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.coder.zzq.smartshow.toast.SmartToast
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.adapter.SystemAdapter
import com.wwy.android.ext.color
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.ui.main.MainActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.SystemViewModel
import kotlinx.android.synthetic.main.fragment_recycleview.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2019/9/25 9:46
 *@描述 体系
 */
class SystemFragment : BaseVMFragment<SystemViewModel>() {
    private val systemAdapter = SystemAdapter()
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun setLayoutResId(): Int = R.layout.fragment_recycleview
    override fun initVM(): SystemViewModel = getViewModel()

    override fun initData() {
        mViewModel.getSystemType()
    }

    override fun initView() {
        rootView =
            (loadPageViewForStatus.getRootView(activity as MainActivity) as LoadPageViewForStatus).apply {
                failTextView().onClick { initData() }
            }

        ArticleRv.apply {
            //  addItemDecoration(SpacesItemDecoration(dip(8), LinearLayoutManager.VERTICAL))
            adapter = systemAdapter.apply {
                isAnimationFirstOnly = true
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
                setOnItemClickListener { adapter, view, position ->
                    val classifyResponse = data[position]
                    startActivity<SystemActivity>(SystemActivity.CLASSIFY_RESPONSE to classifyResponse)
                }
                registerListener {
                    onTypeTextClick { tag, position ->
                        startActivity<SystemActivity>(
                            SystemActivity.CLASSIFY_RESPONSE to data[position],
                            SystemActivity.PITCH_ITEM to tag
                        )
                    }
                }
            }
            backgroundColor = color(R.color.color_page_bg)
        }
        refreshLayout.apply {
            setOnRefreshListener { initData() }
            setEnableLoadMore(false)
        }
    }


    override fun startObserve() {
        mViewModel.run {
            systemClassifyListModel.observe(this@SystemFragment, Observer {
                if (!it.isRefresh) refreshLayout.finishRefresh()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        systemAdapter.setEmptyView(rootView)
                    }

                }
                it.showSuccess?.let { list ->
                    systemAdapter.setList(list)
                }
                it.showError?.let { }//加载失败
            })
        }
    }
}