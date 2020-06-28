package com.leshu.superbrain.view.loadpage

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.leshu.superbrain.R
import com.leshu.superbrain.ext.color
import org.jetbrains.anko.*

class loadPageViewForStatus @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private lateinit var failText: TextView
    private lateinit var noNetText: TextView
    private lateinit var emptyText: TextView
    private lateinit var progressBar: ProgressBar

    init {
        verticalLayout {
            failText = textView {
                textSize = 14f
                textColor = color(R.color.color_8A000000)
                text = "加载错误,点我重试"
            }
            failText.layoutParams =
                LayoutParams(wrapContent, wrapContent).also { gravity = Gravity.CENTER }
            noNetText = textView {
                textSize = 14f
                textColor = color(R.color.color_8A000000)
                text = "网络错误,点我重试"
            }
            noNetText.layoutParams =
                LayoutParams(wrapContent, wrapContent).also { gravity = Gravity.CENTER }
            emptyText = textView {
                textSize = 14f
                textColor = R.color.color_8A000000
                text = "还木有数据哦"
            }
            emptyText.layoutParams =
                LayoutParams(wrapContent, wrapContent).also { gravity = Gravity.CENTER }
            progressBar = progressBar {
                indeterminateTintList = ColorStateList.valueOf(color(R.color.colorPrimary))
                indeterminateTintMode = PorterDuff.Mode.SRC_ATOP

            }
            progressBar.layoutParams =
                LayoutParams(wrapContent, wrapContent).also { gravity = Gravity.CENTER }
        }.layoutParams = LayoutParams(matchParent, matchParent)
    }

    fun failTextView(): TextView {
        return failText
    }

    fun noNetTextView(): TextView {
        return noNetText
    }

    fun emptyTextView(): TextView {
        return emptyText
    }

    fun progressBarView(): ProgressBar {
        return progressBar
    }

}
