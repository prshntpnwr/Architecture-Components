package com.example.prashant.databinding;

import android.arch.lifecycle.ViewModel;

/**
 * The first time the ViewModelProviders.of method is called by MainActivity,
 * it creates a new ViewModel instance. When this method is called again,
 * which happens whenever onCreate is called, it will return the pre-existing
 * ViewModel associated with the MainActivity.This is what preserves the data.
 * checkout {@link-https://medium.com/google-developers/viewmodels-a-simple-example-ed5ac416317e}
 * for starters
 */
public class Contact extends ViewModel {
    // data to be maintain during activity life cycle
    private String name, mobile, email, address;

    /**
     * do heavy lifting tasks such as transient data fetch from remote server / local db or process here
     * for now we're just create dummy data
     */
    public Contact() {
        this.name = "Name";
        this.mobile = "(+91) 9876543210";
        this.email = "name@user.com";
        this.address = "Home";
    }

    /**
     * parameterized contructor for setting data directly
     */
    public Contact(String name, String mobile, String email, String address) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    /**
     * getting and setter methods
     */
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
