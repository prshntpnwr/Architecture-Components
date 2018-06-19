package com.example.prashant.databinding.di.module;

import android.test.suitebuilder.annotation.Suppress;

import com.example.prashant.databinding.ui.ListItemFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    public abstract ListItemFragment contributeListFragment();
}
