package com.example.prashant.databinding.binding

import android.databinding.BindingAdapter
import android.support.v4.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import android.widget.ImageView
import javax.inject.Inject

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters @Inject constructor(val fragment: Fragment) {

    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(fragment).load(url).into(imageView)
    }
}