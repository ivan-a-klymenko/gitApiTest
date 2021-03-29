package ru.bk.klim9.xingtest.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * Configures bindings to [DaggerViewModelFactory], injectable into a [ViewModelProvider.Factory].
 */
@Module
abstract class DaggerViewModelInjectionModule {
    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}