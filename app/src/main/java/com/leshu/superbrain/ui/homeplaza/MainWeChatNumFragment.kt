package com.leshu.superbrain.ui.homeplaza

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.jeremyliao.liveeventbus.LiveEventBus
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.MyFragmentPagerAdapter
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.ext.inflate
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.ui.homepage.ProjectTypeFragment
import com.leshu.superbrain.view.loadpage.BasePageViewForStatus
import com.leshu.superbrain.view.loadpage.SimplePageViewForStatus
import com.leshu.superbrain.vm.HomePlazaViewModel
import com.leshu.superbrain.vm.WeChatNumViewModel
import kotlinx.android.synthetic.main.fragment_main_project.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/6/1 11:43
 *@描述 公众号主页
 */
class MainWeChatNumFragment : BaseVMFragment<WeChatNumViewModel>() {
    override fun setLayoutResId(): Int = R.layout.fragment_main_project
    override fun initVM(): WeChatNumViewModel = getViewModel()
    private val mFragmentList = mutableListOf<Fragment>()
    private val loadPageViewForStatus: BasePageViewForStatus = SimplePageViewForStatus()
    override fun initView() {
        llMainProjectloadPageViewForStatus.failTextView().onClick { mViewModel.loadBlogType() }
        ViewPager2Delegate(vpMainProject, tlMainProject)
        vpMainProject.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            private var currentPosition = 0     //当前滑动位置
            private var oldPosition = 0          //上一个滑动位置
            override fun onPageScrollStateChanged(state: Int) {
                if (state == 0) {
                    if (currentPosition == oldPosition) {
                        if (currentPosition == 0)
                            LiveEventBus.get("MAIN_PLAZA_CUT").post("")
                    }
                    oldPosition = currentPosition
                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                currentPosition = position
            }

        })

    }

    override fun initData() {
        mViewModel.loadBlogType()
    }

    override fun startObserve() {
        mViewModel.apply {
            mBlogTypeListModel.observe(this@MainWeChatNumFragment, Observer { it ->
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    llMainProjectloadPageViewForStatus.visibility = View.VISIBLE
                    loadPageViewForStatus.convert(llMainProjectloadPageViewForStatus, loadPageStatus)
                }
                it.showSuccess?.let { list ->
                    mFragmentList.clear()
                    llMainProjectloadPageViewForStatus.visibility = View.GONE
                    tlMainProject.removeAllViews()
                    list.toMutableList().apply {
                        forEach {
                            tlMainProject?.let { tlMainProject ->
                                tlMainProject.inflate(R.layout.layout_project_tab, false).apply {
                                    findViewById<TextView>(R.id.tvTabLayoutTitle)?.text = it.name
                                    tlMainProject.addView(this)
                                }
                            }
                            mFragmentList.add(
                                WeChatNumTypeFragment.newInstance(it.id)
                            )
                        }
                    }
                    activity?.let { activity ->
                        vpMainProject.adapter = MyFragmentPagerAdapter(activity, mFragmentList)
                    }
                }
            })
        }
    }
}