package com.wwy.android.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * @创建者wwy
 * @创建时间 2020/6/10 16:35
 * @描述
 */
class SpacesItemDecoration(private val space: Int, private val orientation: Int) :
    ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.right = space
        } else {
            outRect.bottom = space
        }
        // Add top margin only for the first item to avoid double space between items
    }

}