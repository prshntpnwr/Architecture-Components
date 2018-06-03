package com.example.prashant.databinding.repo;

import android.arch.lifecycle.MutableLiveData;

import com.example.prashant.databinding.data.ContactDao;
import com.example.prashant.databinding.data.Contact;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class Repository {
    private ContactDao contactDao;
    private Executor executor;

    @Inject
    public Repository(ContactDao contactDao, Executor executor) {
        this.contactDao = contactDao;
        this.executor = executor;
    }

    public MutableLiveData<ArrayList<Contact>> get() {
        refreshTask();
        return contactDao.loadAll();
    }

    private void refreshTask() {
        // running in a background thread
        // check if data was fetched recently, otherwise call web server and fetch results
        // refresh the data
        // TODO check for error etc.
        // Update the database.The LiveData will automatically refresh so
        // we don't need to do anything else here besides updating the database

        executor.execute(() -> {
            int i = 0;
            do {
                contactDao.save(new Contact("Name",
                        "111-222-3333", "a@b.com", "random"));
                i++;
            } while (i < 10);
        });
    }
}
