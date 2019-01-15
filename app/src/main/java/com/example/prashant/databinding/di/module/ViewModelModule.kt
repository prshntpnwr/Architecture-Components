package com.example.prashant.databinding.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.example.prashant.databinding.di.ViewModelKey
import com.example.prashant.databinding.observer.ItemFactory
import com.example.prashant.databinding.observer.ItemViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ItemViewModel::class)
    abstract fun bindItemViewModel(viewModel: ItemViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ItemFactory): ViewModelProvider.Factory
}