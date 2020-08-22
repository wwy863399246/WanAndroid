package com.wwy.android.ui.homesyetem

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.angcyo.tablayout.delegate2.ViewPager2Delegate
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.adapter.MyFragmentPagerAdapter
import com.wwy.android.data.bean.ClassifyResponse
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.inflate
import com.wwy.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_system.*
import kotlinx.android.synthetic.main.layout_custom_navigationbar_view.view.*

/**
 *@创建者wwy
 *@创建时间 2020/8/20 0020 下午 15:45
 *@描述
 */
class SystemActivity : BaseActivity() {
    companion object {
        const val CLASSIFY_RESPONSE = "classify_Response"
        const val PITCH_ITEM = "pitch_item"
    }

    private val mFragmentList = mutableListOf<Fragment>()
    private lateinit var classifyResponse: ClassifyResponse
    private var tag: Int = 0
    override fun setLayoutId(): Int = R.layout.activity_system
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.systemNv)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        classifyResponse = intent?.getParcelableExtra(CLASSIFY_RESPONSE) ?: return
        tag = intent?.getIntExtra(PITCH_ITEM, 0) ?: return
        systemNv.run {
            ivBackNavigationBar.clickWithTrigger { finish() }
            setLeftTitleNavigationBarText(classifyResponse.name)
        }
        classifyResponse.children?.forEach { it ->
            tlMainSystem?.let { tlMainSystem ->
                tlMainSystem.inflate(R.layout.layout_project_tab, false).apply {
                    findViewById<TextView>(R.id.tvTabLayoutTitle)?.text = it.name
                    tlMainSystem.addView(this)
                }
            }
            mFragmentList.add(
                SystemTypeFragment.newInstance(it.id)
            )

        }
        vpMainSystem.adapter = MyFragmentPagerAdapter(this, mFragmentList)
        ViewPager2Delegate(vpMainSystem, tlMainSystem).apply {
            tlMainSystem.setupViewPager(this)
            onPageSelected(tag)
            onSetCurrentItem(0, tag)
        }

    }

    override fun initData() {
    }

}