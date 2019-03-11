package com.example.prashant.databinding.di

import android.app.Application
import com.example.prashant.databinding.di.module.ActivityModule
import com.example.prashant.databinding.di.module.AppModule
import javax.inject.Singleton
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AndroidInjectionModule::class),
    (AppModule::class),
    (ActivityModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}