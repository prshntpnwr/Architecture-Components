package com.example.prashant.databinding.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.prashant.databinding.data.Contact;
import com.example.prashant.databinding.repo.Repository;

import java.util.ArrayList;

import javax.inject.Inject;

class ItemViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Contact>> contacts;
    private Repository repository;

    @Inject
    public ItemViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<ArrayList<Contact>> getContacts() {
        return contacts == null ? repository.get() : contacts;
    }
}