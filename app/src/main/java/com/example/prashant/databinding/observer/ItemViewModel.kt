package com.example.prashant.databinding.observer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prashant.databinding.data.Contact
import com.example.prashant.databinding.repo.Repository

import javax.inject.Inject

class ItemViewModel @Inject constructor(
        val repository: Repository
) : ViewModel() {
    var contacts = MutableLiveData<List<Contact>>()

    fun getContacts(): LiveData<List<Contact>> {
        return if (this.contacts.value == null) repository.get() else contacts
    }

    fun init() {
        this.contacts.postValue(repository.get().value)
    }
}
