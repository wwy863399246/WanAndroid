package com.leshu.superbrain.ui.homepage

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.HomePageAdapter
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomePageFragment : BaseVMFragment<MainViewModel>() {
    private val homePageAdapter = HomePageAdapter()
    override fun providerVMClass(): Class<MainViewModel>? = MainViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_home_page


    override fun initData() {
        mViewModel.loadHomeArticles(1)
    }

    override fun initView() {
        firstPageRv.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = homePageAdapter
        }
        homePageAdapter.run {
            openLoadAnimation(BaseQuickAdapter.SCALEIN)
            setOnLoadMoreListener({ loadMore() }, firstPageRv)
        }

    }

    override fun startObserve() {
        mViewModel.apply {
            homeArticles.observe(this@HomePageFragment, Observer {
                homePageAdapter.setNewData(it)
            })
        }
    }

    private fun loadMore() {
    }

}