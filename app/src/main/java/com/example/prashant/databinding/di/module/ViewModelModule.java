package com.example.prashant.databinding.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.prashant.databinding.di.ViewModelKey;
import com.example.prashant.databinding.observer.ItemFactory;
import com.example.prashant.databinding.observer.ItemViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@SuppressWarnings("unused")
@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ItemViewModel.class)
    public abstract ViewModel bindItemViewModel(ItemViewModel viewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ItemFactory factory);
}