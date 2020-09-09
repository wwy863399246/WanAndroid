package com.wwy.android.ui.homemine.activity

import android.content.DialogInterface
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.BaseQuickAdapter
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.coder.zzq.smartshow.toast.SmartToast
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.adapter.HomePageAdapter
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.color
import com.wwy.android.ext.resourceId
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.ui.main.DetailActivity
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.LoadPageStatus
import com.wwy.android.view.loadpage.LoadPageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.ReadHistoryViewMode
import kotlinx.android.synthetic.main.activity_read_history.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.textColor
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 上午 0:22
 *@描述
 */
class ReadHistoryActivity : BaseVMActivity<ReadHistoryViewMode>() {
    private val homePageAdapter = HomePageAdapter()
    private var mPosition: Int = -1
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    private var rootView: LoadPageViewForStatus? = null
    override fun initVM(): ReadHistoryViewMode = getViewModel()
    override fun setLayoutId(): Int = R.layout.activity_read_history
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.activityRecycleNv)
        }
    }

    override fun startObserve() {
        mViewModel.run {
            mReadHistoryListModel.observe(this@ReadHistoryActivity, Observer {
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    rootView?.let { rootView ->
                        loadPageViewForStatus.convert(rootView, loadPageStatus)
                        homePageAdapter.setEmptyView(rootView)
                    }
                }
                it.showSuccess?.let { list ->
                    homePageAdapter.run {
                        setList(list)
                    }
                }
                it.showError?.let { errorMsg ->//加载失败处理
                    SmartToast.show(errorMsg)
                }

            })
            mDeleteReadHistoryState.observe(this@ReadHistoryActivity, Observer {
                if (it.showLoading) showProgressDialog(R.string.delete_history) else dismissProgressDialog()
                if (it.showEnd) {
                    SmartSnackbar.get(this@ReadHistoryActivity)
                        .show(R.string.history_delete_success)
                    homePageAdapter.remove(mPosition)
                    if (homePageAdapter.data.isEmpty()) {
                        this@ReadHistoryActivity.rootView?.let { rootView ->
                            loadPageViewForStatus.convert(rootView, LoadPageStatus.Empty)
                            homePageAdapter.setEmptyView(rootView)
                        }
                    }
                }
                it.showError?.let { errorMsg ->
                    SmartSnackbar.get(this@ReadHistoryActivity).show(errorMsg)
                }
            })
        }
    }


    override fun initView(savedInstanceState: Bundle?) {
        rootView = (loadPageViewForStatus.getRootView(this) as LoadPageViewForStatus).apply {
            failTextView().onClick { initData() }
        }
        activityRecycleNv.run {
            ivBackNavigationBar.clickWithTrigger {
                finish()
            }
        }
        activityRecycleRv.apply {
            adapter = homePageAdapter.apply {
                setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
                setOnItemClickListener { _, _, position ->
                    val article = data[position]
                    startActivity<DetailActivity>(DetailActivity.PARAM_ARTICLE to article)
                }
                setOnItemLongClickListener { _, _, position ->
                    val dialog = AlertDialog.Builder(this@ReadHistoryActivity)
                        .setMessage(R.string.confirm_delete_history)
                        .setPositiveButton(R.string.confirm) { _, _ ->
                            mViewModel.deleteReadHistory(homePageAdapter.data[position])
                            mPosition = position
                        }
                        .setNegativeButton(R.string.cancel) { _, _ -> }
                        .show()
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).textColor =
                        color(TypedValue().resourceId(R.attr.colorAccent, theme))
                    dialog.getButton(DialogInterface.BUTTON_NEGATIVE).textColor =
                        color(TypedValue().resourceId(R.attr.colorAccent, theme))
                    true
                }
            }

        }
    }

    override fun initData() {
        mViewModel.queryAllReadHistory()
    }
}