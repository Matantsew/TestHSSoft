package com.example.testd.di

import com.example.testd.MainActivity
import com.example.testd.ui.ListContinentsFragment
import dagger.Component

@Component(modules = [ListContinentsModule:: class])
@ListCountriesScope
interface ListCountriesComponent {

    fun inject(listContinentsFragment: ListContinentsFragment)

    fun inject(listContinentsFragment: MainActivity)
}