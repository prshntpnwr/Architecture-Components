package com.example.prashant.databinding.observer

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.example.prashant.databinding.data.Contact
import com.example.prashant.databinding.repo.Repository

import javax.inject.Inject

class ItemViewModel @Inject
constructor(private val repository: Repository) : ViewModel() {
    var contacts = MutableLiveData<List<Contact>>()

    fun getContacts(): LiveData<List<Contact>> {
        return if (this.contacts == null) repository.get() else contacts
    }

    fun init() {
        this.contacts.postValue(repository.get().value)
    }
}
