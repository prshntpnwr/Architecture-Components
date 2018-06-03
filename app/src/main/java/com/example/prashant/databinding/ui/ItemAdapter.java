package com.example.prashant.databinding.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.prashant.databinding.data.Contact;
import com.example.prashant.databinding.databinding.ContactBinding;

import java.util.ArrayList;

/**
 * Created by prashant on 18/5/18.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private ArrayList<Contact> contactArrayList;

    public ItemAdapter(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactBinding itemBinding = ContactBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        holder.bind(contactArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ContactBinding binding;

        ViewHolder(ContactBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Contact item) {
            Log.d("Item Adapter ", item.getName());
            binding.setContact(item);
            binding.executePendingBindings();
        }
    }
}