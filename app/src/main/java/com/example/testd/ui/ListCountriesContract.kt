package com.example.testd.ui

import com.example.domain.repository.entity.Country

interface ListCountriesContract {

    suspend fun fetchListOfCountries(): List<Country>?

    suspend fun obtainCountryByCode(code: String): Country?

    interface View{
        suspend fun initializeList()
    }
}
