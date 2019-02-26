package com.example.prashant.databinding.binding

import androidx.databinding.BindingAdapter
import android.view.View

/**
 * Data Binding adapters specific to the app.
 */
class BindingAdapters {

    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

}
