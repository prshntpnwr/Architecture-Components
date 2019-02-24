package com.example.prashant.databinding.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface ContactDao {
    @Insert(onConflict = REPLACE)
    fun save(contact: Contact)

    @Query("SELECT * FROM contact WHERE id = :id")
    fun load(id: String): LiveData<Contact>

    @Query("SELECT * FROM contact")
    fun loadAll(): LiveData<List<Contact>>

    @Query("DELETE FROM contact WHERE id = :id")
    fun delete(id: String)

    @Update
    fun update(contact: Contact)
}