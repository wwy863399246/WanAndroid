package com.leshu.superbrain.util

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList

/**
 *@创建者wwy
 *@创建时间 2019/11/6 10:27
 *@描述
 */
class ListBoundaryCallback<Value>(private val listLiveData: MutableLiveData<ListStatus>) : PagedList.BoundaryCallback<Value>() {
    override fun onZeroItemsLoaded() {
        listLiveData.value = ListStatus.EMPTY
    }

    override fun onItemAtEndLoaded(itemAtEnd: Value) {
        listLiveData.value = ListStatus.END
    }

    override fun onItemAtFrontLoaded(itemAtFront: Value) {
        // ignored, since we only ever append to what's in the DB
        // listLiveData.value = AtFrontEnd
    }
}