package com.leshu.superbrain.ui.homepage

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnLoadMoreListener
import com.chad.library.adapter.base.module.LoadMoreModule
import com.leshu.superbrain.R
import com.leshu.superbrain.adapter.HomePageAdapter
import com.leshu.superbrain.ui.base.BaseVMFragment
import com.leshu.superbrain.vm.MainViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import timber.log.Timber

/**
 *@创建者wwy
 *@创建时间 2019/9/17 11:58
 *@描述
 */
class HomePageFragment : BaseVMFragment<MainViewModel>(), OnLoadMoreListener {
    private val homePageAdapter = HomePageAdapter()
    override fun providerVMClass(): Class<MainViewModel>? = MainViewModel::class.java
    override fun setLayoutResId(): Int = R.layout.fragment_home_page


    override fun initData() {
        refresh()
    }

    override fun initView() {
        firstPageRv.run {
            layoutManager = LinearLayoutManager(activity)
            adapter = homePageAdapter
        }
        homePageAdapter.run {
            loadMoreModule.setOnLoadMoreListener(this@HomePageFragment)
            isAnimationFirstOnly = true
            setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)
        }

    }

    private fun refresh() {
        mViewModel.loadHomeArticles(true)
    }

    override fun startObserve() {
        mViewModel.apply {
            listModel.observe(this@HomePageFragment, Observer {
                it.showLoading.let {

                }
                it.showSuccess.let { list ->
                    homePageAdapter.run {
                        loadMoreModule.isEnableLoadMore = false
                        if (it.isRefresh) setList(list) else addData(list!!)
                        loadMoreModule.isEnableLoadMore = true
                        loadMoreModule.loadMoreComplete()
                    }
                }
                if (it.showEnd) homePageAdapter.loadMoreModule.loadMoreEnd()

            })
        }
    }

    override fun onLoadMore() {
        mViewModel.loadHomeArticles(false)
    }


}