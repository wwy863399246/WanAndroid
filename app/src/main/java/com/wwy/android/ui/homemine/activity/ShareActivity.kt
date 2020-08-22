package com.wwy.android.ui.homemine.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.hideSoftInput
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.vm.MyCollectAndShareViewModel
import kotlinx.android.synthetic.main.activity_share.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/16 0016 下午 13:07
 *@描述
 */
class ShareActivity : BaseVMActivity<MyCollectAndShareViewModel>() {
    override fun initVM(): MyCollectAndShareViewModel = getViewModel()
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.shareNv)
        }
    }

    override fun startObserve() {
        mViewModel.run {
            userLiveData.observe(this@ShareActivity, Observer {
                acetSharePeople.setText(it.publicName)
            })
            mShareStatus.observe(this@ShareActivity, Observer {
                if (it.showLoading) showProgressDialog(R.string.sharing_article) else dismissProgressDialog()
                if (it.showEnd) {
                    SmartSnackbar.get(this@ShareActivity).show(R.string.share_article_success)
                    acetTitle.setText("")
                    acetlink.setText("")
                }
                it.showError?.let { errorMsg ->
                    SmartSnackbar.get(this@ShareActivity).show(errorMsg)
                }
            })
        }
    }

    override fun setLayoutId(): Int = R.layout.activity_share

    override fun initView(savedInstanceState: Bundle?) {
        shareNv.apply {
            ivBackNavigationBar.clickWithTrigger { finish() }
            tvRightTitleNavigationBar.clickWithTrigger {
                val title = acetTitle.text.toString().trim()
                val link = acetlink.text.toString().trim()
                if (title.isEmpty()) {
                    SmartSnackbar.get(this@ShareActivity).show(R.string.title_toast)
                    return@clickWithTrigger
                }
                if (link.isEmpty()) {
                    SmartSnackbar.get(this@ShareActivity).show(R.string.link_toast)
                    return@clickWithTrigger
                }
                tvRightTitleNavigationBar.hideSoftInput()
                mViewModel.share(title, link)
            }
        }
    }

    override fun initData() {

    }
}