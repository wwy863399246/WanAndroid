package com.wwy.android.ui.main.search

import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.wwy.android.R
import com.wwy.android.adapter.SearchHistoryAdapter
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.inflate
import com.wwy.android.ui.base.BaseVMFragment
import com.wwy.android.vm.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search_history.*
import kotlinx.android.synthetic.main.item_hot_search.view.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 下午 23:28
 *@描述
 */
class SearchHistoryFragment : BaseVMFragment<SearchViewModel>() {
    companion object {
        fun newInstance() = SearchHistoryFragment()
    }

    private lateinit var searchHistoryAdapter: SearchHistoryAdapter
    override fun initVM(): SearchViewModel {
        val viewModel: SearchViewModel by activityViewModels()
        return viewModel
    }

    override fun startObserve() {
        mViewModel.run {
            mHotWord.observe(viewLifecycleOwner, Observer {
                it?.forEach { hotWord ->
                    flexBoxSearchHistory.inflate(R.layout.item_hot_search, false).apply {
                        tvHotSearchText?.text = hotWord.name
                        tvHotSearchText.clickWithTrigger {
                            (activity as? SearchActivity)?.fillSearchInput(hotWord.name)
                        }
                        flexBoxSearchHistory.addView(this)
                    }
                }
                tvHotSearch.isVisible = it != null
            })
            saveState.observe(viewLifecycleOwner, Observer {
                val searchHistory = getSearchHistory()
                searchHistoryAdapter.submitList(searchHistory)
                tvSearchHistory.isGone = searchHistory.isEmpty()
            })
        }
    }

    override fun setLayoutResId(): Int = R.layout.fragment_search_history

    override fun initView() {
        searchHistoryAdapter = SearchHistoryAdapter(activity as SearchActivity).apply {
            rvSearchHistory.adapter = this
            onItemClickListener = {
                (activity as? SearchActivity)?.fillSearchInput(data[it])
            }
            onDeleteClickListener = {
                mViewModel.deleteSearchHistory(searchHistoryAdapter.data[it])
            }
        }
    }

    override fun initData() {
        val searchHistory = mViewModel.getSearchHistory()
        searchHistoryAdapter.submitList(searchHistory)
        tvSearchHistory.isGone = searchHistory.isEmpty()
    }
}