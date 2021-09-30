package com.example.testd.di

import com.example.data.repository.CountriesRepositoryImpl
import com.example.domain.repository.CountriesRepository
import com.example.testd.ui.ListCountriesContract
import com.example.testd.ui.ListCountriesPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ListContinentsModule {

    @Binds
    @ListCountriesScope
    abstract fun bindCountriesRepository(impl: CountriesRepositoryImpl): CountriesRepository
}