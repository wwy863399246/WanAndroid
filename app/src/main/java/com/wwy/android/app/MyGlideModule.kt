/*
 *   Copyright 2018 Google LLC
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.wwy.android.app

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context

import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

import android.content.Context.ACTIVITY_SERVICE
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
import com.bumptech.glide.load.DecodeFormat.PREFER_RGB_565

/**
 * Glide module configurations
 */
@GlideModule
class MyGlideModule : AppGlideModule() {

    @SuppressLint("CheckResult")
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val defaultOptions = RequestOptions()
        // Prefer higher quality images unless we're on a low RAM device
        val activityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        val format = if (activityManager.isLowRamDevice) PREFER_RGB_565 else PREFER_ARGB_8888
        // Disable hardware bitmaps as they don't play nicely with Palette
        defaultOptions.swap(format, builder)

    }

    //扩展函数
    @SuppressLint("CheckResult")
    fun RequestOptions.swap(format: DecodeFormat, builder: GlideBuilder) {
        this.format(format)
        this.disallowHardwareConfig()
        builder.setDefaultRequestOptions(this)
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}
