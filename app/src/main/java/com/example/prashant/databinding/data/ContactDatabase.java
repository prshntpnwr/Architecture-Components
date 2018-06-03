package com.example.prashant.databinding.data;

import android.arch.persistence.room.Database;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase {
    public abstract ContactDao contactDao();
}
