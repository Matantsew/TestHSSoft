package com.example.testd.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val listCountriesRepository: CountriesRepository) : DetailsContract.Presenter, ViewModel(){

    private var view: DetailsContract.View? = null

    override fun bindView(view: DetailsContract.View){
        this.view = view
    }

    override fun onCountryClicked(code: String) {
        viewModelScope.launch(Dispatchers.IO){
            val country = listCountriesRepository.getCountryByCode(code)
            view?.showCountry(country)
        }
    }
}