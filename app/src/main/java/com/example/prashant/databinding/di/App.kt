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
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        initDagger()
        context = applicationContext
    }

    private fun initDagger() {
       AppInjector().init(this)
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}
