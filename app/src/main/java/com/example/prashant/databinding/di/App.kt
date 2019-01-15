package com.example.prashant.databinding.di

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context

import javax.inject.Inject

import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector

class App : Application(), HasActivityInjector {

    @Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        this.initDagger()
        context = applicationContext
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    private fun initDagger() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}
