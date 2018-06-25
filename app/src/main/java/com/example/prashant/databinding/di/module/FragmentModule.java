package com.example.prashant.databinding.di.module;

import com.example.prashant.databinding.ui.ListItemFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@SuppressWarnings("unused")
@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    public abstract ListItemFragment contributeListFragment();
}
