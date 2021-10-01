package com.example.testd.di

import com.example.data.repository.CountriesRepositoryImpl
import com.example.domain.repository.CountriesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ListContinentsModule {

    @Binds
    @ListCountriesScope
    abstract fun bindCountriesRepository(impl: CountriesRepositoryImpl): CountriesRepository
}