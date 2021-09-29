package com.example.testd.ui

import com.example.domain.repository.CountriesRepository
import com.example.domain.repository.entity.Country
import javax.inject.Inject

class ListCountriesPresenter @Inject constructor(private val listCountriesRepository: CountriesRepository) : ListCountriesContract{

    override suspend fun fetchListOfCountries(): List<Country>?{
        return listCountriesRepository.getCountries()
    }

    override suspend fun obtainCountryByCode(code: String): Country? {
        return listCountriesRepository.getCountryByCode(code)
    }
}