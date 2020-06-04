package com.leshu.superbrain.ui.homepage

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
import com.leshu.superbrain.view.loadpage.BasePageStateView
import com.leshu.superbrain.view.loadpage.SimpleLoadPageView
import com.leshu.superbrain.vm.HomeProjectViewModel
import kotlinx.android.synthetic.main.fragment_main_project.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class MainProjectFragment : BaseVMFragment<HomeProjectViewModel>() {
    private val mFragmentList = mutableListOf<Fragment>()
    override fun providerVMClass(): Class<HomeProjectViewModel>? = HomeProjectViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_main_project
    private val loadPageView: BasePageStateView = SimpleLoadPageView()
    override fun initView() {
        llMainProjectLoadPageView.failTextView().onClick { mViewModel.loadProjectClassify() }
        ViewPager2Delegate(vpMainProject, tlMainProject)
        mViewModel.loadProjectClassify()
        vpMainProject.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            private var currentPosition = 0     //当前滑动位置
            private var oldPosition = 0          //上一个滑动位置
            override fun onPageScrollStateChanged(state: Int) {
                if (state == 0) {
                    if (currentPosition == oldPosition) {
                        if (currentPosition == 0)
                            LiveEventBus.get("HOME_PAGE_CUT").post("")
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
        mViewModel.run {
            mMainProjectListModel.observe(this@MainProjectFragment, Observer { it ->
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    llMainProjectLoadPageView.visibility = View.VISIBLE
                    loadPageView.convert(llMainProjectLoadPageView, loadPageStatus)
                }
                it.showSuccess?.let {
                    mFragmentList.clear()
                    val classifyResponse = ClassifyResponse(
                        null, 0, 0, getString(R.string.newest_project), 0, 0, false, 0
                    )
                    llMainProjectLoadPageView.visibility = View.GONE
                    tlMainProject.removeAllViews()
                    it.toMutableList().apply {
                        add(0, classifyResponse)
                        forEach {
                            tlMainProject.inflate(R.layout.layout_project_tab, false).apply {
                                findViewById<TextView>(R.id.tvTabLayoutTitle)?.text = it.name
                                tlMainProject.addView(this)
                            }
                            mFragmentList.add(
                                ProjectTypeFragment.newInstance(it.id)
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
