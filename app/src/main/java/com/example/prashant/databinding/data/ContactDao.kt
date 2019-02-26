package com.example.prashant.databinding.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    @Insert(onConflict = REPLACE)
    fun save(contact: Contact)

    @Query("SELECT * FROM contact WHERE id = :id")
    fun load(id: Int): LiveData<Contact>

    @Query("SELECT * FROM contact")
    fun loadAll(): LiveData<List<Contact>>

    @Query("DELETE FROM contact WHERE id = :id")
    fun delete(id: Int)

    @Update
    fun update(contact: Contact)
}