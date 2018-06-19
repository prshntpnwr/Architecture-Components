package com.example.prashant.databinding.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ContactDao {
    @Insert(onConflict = REPLACE)
    void save(Contact contact);

    @Query("SELECT * FROM contact WHERE id = :id")
    LiveData<Contact> load(String id);

    @Query("SELECT * FROM contact")
    LiveData<List<Contact>> loadAll();

    @Query("DELETE FROM contact WHERE id = :id")
    void delete(String id);

    @Update
    void update(Contact contact);
}