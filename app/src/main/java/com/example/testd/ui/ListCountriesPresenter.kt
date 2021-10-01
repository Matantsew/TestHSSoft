package com.example.testd.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.CountriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListCountriesPresenter @Inject constructor(
    private val listCountriesRepository: CountriesRepository
) : ListCountriesContract.Presenter, ViewModel() {

    private var view: ListCountriesContract.View? = null

    override fun bindView(view: ListCountriesContract.View) {
        this.view = view
    }

    override fun initUI() {
        fetchCountries()
    }

    override fun unbindView() {
        view = null
    }

    private fun fetchCountries() {
        viewModelScope.launch {

            val countries = listCountriesRepository.getCountries()

            if (countries == null) {
                view?.hideProgress()
                view?.showError()
            }
            else view?.showList(countries)
        }
    }
}