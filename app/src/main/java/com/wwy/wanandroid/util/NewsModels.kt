package com.wwy.wanandroid.util

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class ListingModel<T>(
    val pagedList: LiveData<PagedList<T>>,
    val listStatus: LiveData<ListStatus>,
    val retry: () -> Unit,
    val refresh: () -> Unit,
    val refreshStatus: LiveData<NetworkState>
)






