package com.example.prashant.databinding.binding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

/**
 * A Data Binding Component implementation for fragments.
 */
class FragmentDataBindingComponent(var fragment: Fragment) : DataBindingComponent {
    override fun getBindingAdapters(): BindingAdapters {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getActivityBindingAdapters() = ActivityBindingAdapters(fragment.requireActivity())

    private val adapter = FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters() = adapter
}