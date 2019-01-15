package com.example.prashant.databinding.di.module

import com.example.prashant.databinding.ui.ListItemFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ListItemFragment
}
