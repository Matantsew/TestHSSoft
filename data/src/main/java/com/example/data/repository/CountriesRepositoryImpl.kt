package com.example.data.repository

import com.apollographql.apollo.coroutines.await
import com.example.domain.repository.entity.Country
import com.example.data.apolloClient
import com.example.domain.repository.CountriesRepository
import com.example.testd.GetCountriesQuery
import com.example.testd.GetCountryQuery
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor() : CountriesRepository {

    override suspend fun getCountries() : List<Country>? {

        val response = apolloClient.query(GetCountriesQuery()).await()
        val data = response.data

        if (data != null && !response.hasErrors()) {
            val countries = data.countries

            val listOfCountries: MutableList<Country> = mutableListOf()

            for (country in countries){
                listOfCountries.add(Country(name = country.name, code = country.code))
            }

            return listOfCountries
        }

        return null
    }

    override suspend fun getCountryByCode(code: String): Country?{

        val response = apolloClient.query(GetCountryQuery(code)).await()
        val data = response.data

        if (data != null && !response.hasErrors()) {

            return Country(
                name = data.country!!.name,
                code = code,
                nat = data.country.native_,
                capital = data.country.capital.toString()
            )
        }

        return null
    }
}