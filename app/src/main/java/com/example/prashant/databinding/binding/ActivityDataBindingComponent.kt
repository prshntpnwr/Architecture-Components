package com.example.prashant.databinding.binding

import android.app.Activity
import android.databinding.DataBindingComponent

/**
 * A Data Binding Component implementation for activities.
 */
class ActivityDataBindingComponent(activity: Activity) : DataBindingComponent {
    override fun getBindingAdapters(): BindingAdapters {
       return BindingAdapters()
    }

    override fun getFragmentBindingAdapters(): FragmentBindingAdapters {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val adapter = ActivityBindingAdapters(activity)

    override fun getActivityBindingAdapters() = adapter
}