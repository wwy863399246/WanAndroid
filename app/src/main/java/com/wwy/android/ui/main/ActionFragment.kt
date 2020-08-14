package com.wwy.android.ui.main

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.coder.zzq.smartshow.toast.SmartToast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wwy.android.R
import com.wwy.android.data.bean.Article
import com.wwy.android.ext.clickWithTrigger
import com.wwy.android.ext.text
import com.wwy.android.ui.main.DetailActivity.Companion.PARAM_ARTICLE
import kotlinx.android.synthetic.main.fragment_detail_acitons.*

/**
 * Created by xiaojianjun on 2019-11-21.
 */
class ActionFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(article: Article): ActionFragment {
            return ActionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PARAM_ARTICLE, article)
                }
            }
        }
    }

    private var behavior: BottomSheetBehavior<View>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_acitons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            val article = getParcelable<Article>(PARAM_ARTICLE) ?: return@run
            llCollect.visibility = if (article.id != 0) View.VISIBLE else View.GONE
            ivCollect.isSelected = article.collect
            tvCollect.text =
                getString(if (article.collect) R.string.cancel_collect else R.string.add_collect)
            llCollect.clickWithTrigger {

                val detailActivity = (activity as? DetailActivity)
                    ?: return@clickWithTrigger
                if (detailActivity.checkLogin()) {
                    ivCollect.isSelected = !article.collect
                    detailActivity.changeCollect()
                    behavior?.state = BottomSheetBehavior.STATE_HIDDEN
                } else {
                    view.postDelayed({ dismiss() }, 300)
                }
            }
            llShare.clickWithTrigger {
                behavior?.state = BottomSheetBehavior.STATE_HIDDEN
                activity?.let {
                    ShareCompat.IntentBuilder.from(it)
                        .setType("text/plain")
                        .setSubject(it.text(R.string.app_name))
                        .setText(article.title + article.link)
                        .setChooserTitle(it.text(R.string.app_name))
                        .startChooser()
                }
            }
            llExplorer.clickWithTrigger {
                openInExplorer(article.link)
                behavior?.state = BottomSheetBehavior.STATE_HIDDEN
            }
            llCopy.clickWithTrigger {
                context?.copyTextIntoClipboard(article.link, article.title)
                activity?.let {
                    SmartSnackbar.get(it).show(it.text(R.string.copy_success))
                }
                behavior?.state = BottomSheetBehavior.STATE_HIDDEN
            }
            llRefresh.clickWithTrigger {
                (activity as? DetailActivity)?.refreshPage()
                behavior?.state = BottomSheetBehavior.STATE_HIDDEN
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val bottomSheet: View = (dialog as BottomSheetDialog).delegate
            .findViewById(com.google.android.material.R.id.design_bottom_sheet)
            ?: return
        behavior = BottomSheetBehavior.from(bottomSheet)
        behavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun show(manager: FragmentManager) {
        if (!this.isAdded) {
            super.show(manager, "ActionFragment")
        }
    }
    private fun Context.copyTextIntoClipboard(text: CharSequence?, label: String? = "") {
        if (text.isNullOrEmpty()) return
        val cbs = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
            ?: return
        cbs.setPrimaryClip(ClipData.newPlainText(label, text))
    }
    private fun openInExplorer(link: String?) {
        startActivity(Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(link)
        })
    }
}