package com.wwy.android.ui.main.search

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.core.view.isGone
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.gyf.immersionbar.ktx.immersionBar
import com.wwy.android.R
import com.wwy.android.ext.*
import com.wwy.android.ui.base.BaseActivity
import com.wwy.android.ui.base.BaseVMActivity
import com.wwy.android.vm.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

/**
 *@创建者wwy
 *@创建时间 2020/8/21 0021 下午 22:34
 *@描述
 */
class SearchActivity : BaseVMActivity<SearchViewModel>() {
    companion object {
        const val FRAGMENT_SEARCH_HISTORY = "fragment_search_history"
        const val FRAGMENT_SEARCH_RESULT = "fragment_search_result"
    }

    override fun setLayoutId(): Int = R.layout.activity_search
    override fun initImmersionBar() {
        super.initImmersionBar()
        immersionBar {
            titleBar(R.id.clTitle)
        }
    }

    override fun initView(savedInstanceState: Bundle?) {
        acetInput.showSoftInput()
        val fragmentMapOf = mapOf<String, Fragment>(
            FRAGMENT_SEARCH_HISTORY to SearchHistoryFragment.newInstance(),
            FRAGMENT_SEARCH_RESULT to SearchResultFragment.newInstance()
        )
        loadFragments(R.id.flContainer, 0, *fragmentMapOf.values.toTypedArray())
        ivBack.clickWithTrigger {
            if (fragmentMapOf.getValue(FRAGMENT_SEARCH_RESULT).isVisible) {
                showHideFragment(fragmentMapOf.getValue(FRAGMENT_SEARCH_HISTORY))
            } else {
                finish()
            }
        }
        showHideFragment(fragmentMapOf.getValue(FRAGMENT_SEARCH_HISTORY))

        acetInput.run {
            addTextChangedListener(afterTextChanged = {
                ivClearSearch.isGone = it.isNullOrEmpty()
            })
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    ivDone.performClick()
                    true
                } else {
                    false
                }
            }
        }
        ivDone.clickWithTrigger {
            val searchWords = acetInput.text.toString()
            if (searchWords.isEmpty()) return@clickWithTrigger
            it.hideSoftInput()
            mViewModel.saveSearchHistory(searchWords)
            val searchResultFragment =
                fragmentMapOf.getValue(FRAGMENT_SEARCH_RESULT) as SearchResultFragment
            showHideFragment(searchResultFragment)
            mViewModel.search(true, searchWords)
        }
        ivClearSearch.clickWithTrigger {
            acetInput.setText("")
        }
    }

    override fun initData() {


    }

    fun fillSearchInput(keywords: String) {
        acetInput.setText(keywords)
        acetInput.setSelection(keywords.length)
    }

    override fun initVM(): SearchViewModel = getViewModel()

    override fun startObserve() {
    }
    override fun onBackPressed() {
        ivBack.performClick()
    }
}