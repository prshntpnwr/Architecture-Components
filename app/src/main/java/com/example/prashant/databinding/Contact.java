package com.example.prashant.databinding;

import android.arch.lifecycle.ViewModel;

/**
 * Created by prashant on 15/2/18.
 */

public class Contact extends ViewModel {

    private String name, mobile, email, address;

    public Contact() {
        this.name = "Name";
        this.mobile = "(+91) 9876543210";
        this.email = "name@user.com";
        this.address = "Home";
    }

    public Contact(String name, String mobile, String email, String address) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
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
