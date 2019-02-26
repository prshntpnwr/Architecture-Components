package com.example.prashant.databinding.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.prashant.databinding.di.ViewModelKey
import com.example.prashant.databinding.observer.ItemViewModel
import com.example.prashant.databinding.observer.ViewModelFactory
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
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}