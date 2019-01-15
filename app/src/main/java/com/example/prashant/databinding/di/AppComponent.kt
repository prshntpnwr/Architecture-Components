package com.example.prashant.databinding.di

import android.app.Application

import com.example.prashant.databinding.di.module.ActivityModule
import com.example.prashant.databinding.di.module.AppModule
import com.example.prashant.databinding.di.module.FragmentModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component

@Singleton
@Component(modules = [ActivityModule::class, FragmentModule::class, AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
