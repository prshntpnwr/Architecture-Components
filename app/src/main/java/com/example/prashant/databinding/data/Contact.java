package com.example.prashant.databinding.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * The first time the ViewModelProviders.of method is called by MainActivity,
 * it creates a new ViewModel instance. When this method is called again,
 * which happens whenever onCreate is called, it will return the pre-existing
 * ViewModel associated with the MainActivity.This is what preserves the data.
 * checkout {@link-https://medium.com/google-developers/viewmodels-a-simple-example-ed5ac416317e}
 * for starters
 */
@Entity(tableName = "contact")
public class Contact {
    // data to be maintain during activity life cycle
    @PrimaryKey
    @NonNull
    private String id;
    private String name, mobile, email, address;

    public Contact() {
    }

    /**
     * parameterized constructor for setting data directly
     */
    @Ignore
    public Contact(String id, String name, String mobile, String email, String address) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    /**
     * getting and setter methods
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
