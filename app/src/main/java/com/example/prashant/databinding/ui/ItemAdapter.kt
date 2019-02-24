package com.example.prashant.databinding.ui

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import com.example.prashant.databinding.data.Contact
import com.example.prashant.databinding.databinding.ContactBinding

import java.util.ArrayList

/**
 * Created by prashant on 18/5/18.
 */
class ItemAdapter internal constructor(
        private val contactArrayList: ArrayList<Contact>
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int
    ): ItemAdapter.ViewHolder {
        val itemBinding = ContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(
            holder: ItemAdapter.ViewHolder,
            position: Int
    ) {
        holder.bind(contactArrayList[position])
    }

    override fun getItemCount(): Int {
        return contactArrayList.size
    }

    inner class ViewHolder(private val binding: ContactBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Contact) {
            binding.contact = item
            binding.executePendingBindings()
        }
    }
}