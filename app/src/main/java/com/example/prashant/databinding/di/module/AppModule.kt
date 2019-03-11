package com.example.prashant.databinding.di.module

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.room.Room
import com.example.prashant.databinding.data.ContactDao
import com.example.prashant.databinding.data.ContactDatabase
import com.example.prashant.databinding.remote.Webservice
import com.example.prashant.databinding.repo.Repository
import com.example.prashant.databinding.utils.dataUtil.AppExecutors
import com.example.prashant.databinding.utils.remoteUtils.LiveDataCallAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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

    @Provides
    fun provideExecutor(): AppExecutors {
        return AppExecutors()
    }

    @Provides
    @Singleton
    fun provideContactRepository(
            webservice: Webservice,
            contactDao: ContactDao,
            executor: AppExecutors
    ): Repository {
        return Repository(webservice, contactDao, executor)
    }

    /**
     * Pagination injection
     */
    @Provides
    @Singleton
    fun providePagingConfig(): PagedList.Config {
        return PagedList.Config.Builder()
                .setPageSize(10)
                .setInitialLoadSizeHint(30)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(true)
                .build()
    }

    @Provides
    @Singleton
    fun providePageBuilder(
            source: DataSource.Factory<Int, Any>,
            config: PagedList.Config,
            executor: AppExecutors
    ): LiveData<PagedList<Any>> {
        return LivePagedListBuilder(source, config)
                .setFetchExecutor(executor.diskIO())
                .build()
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
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .baseUrl(baseUrl)
                .build()
    }

    @Provides
    @Singleton
    fun provideApiWebservice(restAdapter: Retrofit): Webservice {
        return restAdapter.create(Webservice::class.java)
    }
}
