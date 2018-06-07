package com.example.prashant.databinding.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.prashant.databinding.data.Contact;
import com.example.prashant.databinding.repo.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

class ItemViewModel extends ViewModel {
    private LiveData<List<Contact>> contacts;
    private Repository repository;

    @Inject
    public ItemViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<Contact>> getContacts() {
        return this.contacts == null ? repository.get() : contacts;
    }
}