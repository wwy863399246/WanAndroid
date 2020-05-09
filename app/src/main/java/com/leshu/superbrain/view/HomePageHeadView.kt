package com.leshu.superbrain.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.leshu.superbrain.R
import org.jetbrains.anko.include

class HomePageHeadView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    init {
        include<View>(R.layout.layout_banner)
    }
}