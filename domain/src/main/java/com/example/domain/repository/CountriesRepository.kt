package com.example.domain.repository

import com.example.domain.repository.entity.Country

interface CountriesRepository {

    suspend fun getCountries(): List<Country>?

    suspend fun getCountryByCode(code: String): Country?
}