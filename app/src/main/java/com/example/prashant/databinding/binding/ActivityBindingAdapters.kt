package com.example.prashant.databinding.binding

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class ActivityBindingAdapters @Inject constructor(activity: Activity) {

    @BindingAdapter("visible")
    fun showView(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @BindingAdapter("drawable")
    fun bindDrawable(imageView: ImageView, drawable: Drawable) {
        imageView.background = drawable
    }
}