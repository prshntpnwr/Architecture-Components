package com.example.prashant.databinding.remote;

import com.example.prashant.databinding.data.Contact;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Webservice {
    @GET("/contact/{contact}")
    Call<Contact> getContacts(@Path("contact") String contactId) ;
}
