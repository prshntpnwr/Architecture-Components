package com.example.prashant.databinding.ui

import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingComponent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.prashant.databinding.R
import com.example.prashant.databinding.data.Contact
import com.example.prashant.databinding.databinding.ContactBinding
import com.example.prashant.databinding.utils.AppExecutors
import com.example.prashant.databinding.utils.DataBoundListAdapter

/**
 * Created by prashant on 18/5/18.
 */
class ItemAdapter(private val dataBindingComponent: DataBindingComponent,
                  appExecutors: AppExecutors,
                  private val callback: ((Contact) -> Unit)?
) : DataBoundListAdapter<Contact, ContactBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<Contact>() {
            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem == newItem
            }
        }
) {
    override fun createBinding(parent: ViewGroup): ContactBinding {
        return DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false,
                dataBindingComponent)
    }

    override fun bind(binding: ContactBinding, item: Contact, position: Int) {
        binding.contact = item
    }
}