package com.example.testd.di

import com.example.testd.ui.ListContinentsFragment
import dagger.Component

@Component(modules = [ListContinentsModule:: class])
interface ListCountriesComponent {

    fun inject(listContinentsFragment: ListContinentsFragment)
}