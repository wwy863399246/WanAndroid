package com.wwy.android.ui.homemine.activity

import android.content.DialogInterface
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.coder.zzq.smartshow.toast.SmartToast
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.util.clearCache
import com.wwy.android.util.getCacheSize
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.MyCollectAndShareViewModel
import kotlinx.android.synthetic.main.activity_my_recycleview.*
import kotlinx.android.synthetic.main.activity_my_recycleview.refreshLayout
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/15 0015 下午 21:26
 *@描述
 */
class MyShareListActivity : BaseVMActivity<MyCollectAndShareViewModel>(), OnLoadMoreListener {
    private val homePageAdapter = HomePageAdapter()
    private var mPosition: Int = -1
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun initVM(): MyCollectAndShareViewModel = getViewModel()
    override fun setLayoutId(): Int = R.layout.activity_my_recycleview
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.activityRecycleNv)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        rootView = (loadPageViewForStatus.getRootView(this) as LoadPageViewForStatus).apply {
            failTextView().onClick { refresh() }
            noNetTextView().onClick { refresh() }
        }

        activityRecycleNv.run {
            setLeftTitleNavigationBarText(R.string.my_share)
            setIvRightNavigationBarOne(R.drawable.ic_baseline_add_24)
            ivRightNavigationBarOne.clickWithTrigger {
                startActivity<ShareActivity>()
            }
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        refreshLayout.apply {
            setOnRefreshListener { refresh() }
            setEnableLoadMore(false)
        }
        activityRecycleRv.apply {
            adapter = homePageAdapter.apply {
                loadMoreModule.setOnLoadMoreListener(this@MyShareListActivity)
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
                setOnItemClickListener { adapter, view, position ->
                    val article = data[position]
                    startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
                }
                setOnItemLongClickListener { adapter, view, position ->
                    val dialog = AlertDialog.Builder(this@MyShareListActivity)
                        .setMessage(R.string.confirm_delete_shared)
                        .setPositiveButton(R.string.confirm) { _, _ ->
                            mViewModel.deleteShare(homePageAdapter.data[position].id)
                            mPosition = position
                        }
                        .setNegativeButton(R.string.cancel) { _, _ -> }
                        .show()
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).textColor =
                        color(TypedValue().resourceId(R.attr.colorAccent, theme))
                    dialog.getButton(DialogInterface.BUTTON_NEGATIVE).textColor =
                        color(TypedValue().resourceId(R.attr.colorAccent, theme))
//                    alert(R.string.confirm_delete_shared) {
//                        yesButton {
//
//                        }
//                        noButton {}
//                    }.show()
                    true
                }
            }
        }
    }

    override fun initData() {
        refresh()
    }

    override fun startObserve() {
        mViewModel.run {
            mListModel.observe(this@MyShareListActivity, Observer {
                if (it.isRefresh) refreshLayout.finishRefresh(it.isRefreshSuccess)
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        homePageAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    homePageAdapter.run {
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
            mShareStatus.observe(this@MyShareListActivity, Observer {
                if (it.showLoading) showProgressDialog(R.string.delete_article) else dismissProgressDialog()
                if (it.showEnd) {
                    SmartSnackbar.get(this@MyShareListActivity)
                        .show(R.string.article_delete_success)
                    homePageAdapter.remove(mPosition)
                    if (homePageAdapter.data.isEmpty()) {
                        this@MyShareListActivity.rootView?.let { rootView ->
                            loadPageViewForStatus.convert(rootView, LoadPageStatus.Empty)
                            homePageAdapter.setEmptyView(rootView)
                        }
                    }
                }
                it.showError?.let { errorMsg ->
                    SmartSnackbar.get(this@MyShareListActivity).show(errorMsg)
                }
            })
        }
    }

    private fun refresh() {
        mViewModel.getShareList(true)
    }

    override fun onLoadMore() {
        mViewModel.getShareList(false)
    }

}