package com.leshu.superbrain.ui.homepage

import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.leshu.superbrain.R
import com.leshu.superbrain.data.bean.ClassifyResponse
import com.leshu.superbrain.ext.inflate
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.view.loadpage.BasePageStateView
import com.leshu.superbrain.view.loadpage.SimpleLoadPageView
import kotlinx.android.synthetic.main.fragment_main_project.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class MainProjectFragment : BaseVMFragment<ProjectViewModel>() {
    override fun providerVMClass(): Class<ProjectViewModel>? = ProjectViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_main_project
    private val loadPageView: BasePageStateView = SimpleLoadPageView()
    override fun initView() {
        llMainProjectLoadPageView.failTextView().onClick { mViewModel.loadProjectClassify() }
        mViewModel.loadProjectClassify()
    }

    override fun initData() {
        mViewModel.run {
            mListModel.observe(this@MainProjectFragment, Observer { it ->
                it.loadPageStatus?.value?.let { loadPageStatus ->
                    llMainProjectLoadPageView.visibility = View.VISIBLE
                    loadPageView.convert(llMainProjectLoadPageView, loadPageStatus)
                }
                it.showSuccess?.let {
                    val classifyResponse = ClassifyResponse(null, 0, 0, "最新项目", 0, 0, false, 0)
                    llMainProjectLoadPageView.visibility = View.GONE
                    tlMainProject.removeAllViews()
                    it.toMutableList().apply {
                        add(0, classifyResponse)
                        forEach {
                            tlMainProject.inflate(R.layout.layout_project_tab, false).apply {
                                findViewById<TextView>(R.id.tvTabLayoutTitle)?.text = it.name
                                tlMainProject.addView(this)
                            }
                        }
                    }
                }
            })
        }
    }
}