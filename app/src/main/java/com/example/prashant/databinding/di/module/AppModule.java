package com.example.prashant.databinding.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.prashant.databinding.data.ContactDao;
import com.example.prashant.databinding.data.ContactDatabase;
import com.example.prashant.databinding.remote.Webservice;
import com.example.prashant.databinding.repo.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Module used to provide dependencies at an application-level.
 */

@Module(includes = {ViewModelModule.class})
public class AppModule {
    // database injection
    @Provides
    @Singleton
    public ContactDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                ContactDatabase.class, "contact.db")
                .build();
    }

    @Provides
    @Singleton
    public ContactDao provideContactDao(ContactDatabase database) {
        return database.contactDao();
    }

    // repository injection
    @Provides
    public Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    public Repository provideContactRepository(Webservice webservice, ContactDao contactDao, Executor executor) {
        return new Repository(webservice, contactDao, executor);
    }

    // network injections
    String BASE_URL = "https://api.contact.com/";

    @Provides
    public Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    public Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public Webservice provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(Webservice.class);
    }
}
