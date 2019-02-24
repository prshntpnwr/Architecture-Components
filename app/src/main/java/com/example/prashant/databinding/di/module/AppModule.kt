package com.example.prashant.databinding.di.module

import android.app.Application
import android.arch.persistence.room.Room

import com.example.prashant.databinding.data.ContactDao
import com.example.prashant.databinding.data.ContactDatabase
import com.example.prashant.databinding.remote.Webservice
import com.example.prashant.databinding.repo.Repository
import com.example.prashant.databinding.utils.AppExecutors
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.util.concurrent.Executor
import java.util.concurrent.Executors

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module used to provide dependencies at an application-level.
 */
@Module(includes = [ViewModelModule::class])
class AppModule {
    // database injection
    @Provides
    @Singleton
    fun provideDatabase(application: Application): ContactDatabase {
        return Room.databaseBuilder(
                application,
                ContactDatabase::class.java,
                "contact.db").build()
    }

    @Provides
    @Singleton
    fun provideContactDao(database: ContactDatabase): ContactDao {
        return database.contactDao()
    }

    // repository injection
    @Provides
    fun provideExecutor(): AppExecutors {
        return AppExecutors()
    }

    @Provides
    @Singleton
    fun provideContactRepository(webservice: Webservice, contactDao: ContactDao, executor: AppExecutors): Repository {
        return Repository(webservice, contactDao, executor)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        val baseUrl = "https://api.contact.com/"
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): Webservice {
        return restAdapter.create(Webservice::class.java)
    }
}
