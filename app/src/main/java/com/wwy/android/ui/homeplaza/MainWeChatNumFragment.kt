package com.wwy.android.ui.homeplaza

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.jeremyliao.liveeventbus.LiveEventBus
import com.wwy.android.R
import com.wwy.android.adapter.MyFragmentPagerAdapter
import com.wwy.android.ext.MAIN_PLAZA_CUT
import com.wwy.android.ext.inflate
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.view.loadpage.BasePageViewForStatus
import com.wwy.android.view.loadpage.SimplePageViewForStatus
import com.wwy.android.vm.WeChatNumViewModel
import kotlinx.android.synthetic.main.fragment_main_project.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.koin.android.ext.android.inject
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
    private val loadPageViewForStatus: BasePageViewForStatus by inject()
    override fun initView() {
        llMainProjectLoadPageViewForStatus.failTextView().onClick { mViewModel.loadBlogType() }
        ViewPager2Delegate(vpMainProject, tlMainProject)
        vpMainProject.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            private var currentPosition = 0     //当前滑动位置
            private var oldPosition = 0          //上一个滑动位置
            override fun onPageScrollStateChanged(state: Int) {
                if (state == 0) {
                    if (currentPosition == oldPosition) {
                        if (currentPosition == 0)
                            LiveEventBus.get(MAIN_PLAZA_CUT).post("")
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
        mViewModel.run {
            mBlogTypeListModel.observe(this@MainWeChatNumFragment, Observer { it ->
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    llMainProjectLoadPageViewForStatus.visibility = View.VISIBLE
                    loadPageViewForStatus.convert(llMainProjectLoadPageViewForStatus, loadPageStatus)
                }
                it.showSuccess?.let { list ->
                    mFragmentList.clear()
                    llMainProjectLoadPageViewForStatus.visibility = View.GONE
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