/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wwy.android.util

import androidx.lifecycle.LiveData
import com.wwy.android.view.loadpage.LoadPageStatus

data class ListModel<T>(
    val showSuccess: List<T>? = null,
    val showLoading: Boolean = false,
    val showError: String? = null,
    val showEnd: Boolean = false, // 加载更多
    val isRefresh: Boolean = false, // 刷新
    val isRefreshSuccess: Boolean = true, // 是否刷新成功
    val needLogin: Boolean? = false,
    val loadPageStatus: LiveData<LoadPageStatus>? = null
)