package com.example.prashant.databinding.remote

import com.example.prashant.databinding.data.Contact

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {
    @GET("/contact/{contact}")
    fun getContacts(@Path("contact") contactId: String): Call<Contact>
}
