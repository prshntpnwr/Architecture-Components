package com.example.prashant.databinding.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ContactDao {
    @Insert(onConflict = REPLACE)
    void save(Contact contact);

    @Query("SELECT * FROM contact WHERE id = :id")
    MutableLiveData<Contact> load(String id);

    @Query("SELECT * FROM contact")
    MutableLiveData<ArrayList<Contact>> loadAll();
}