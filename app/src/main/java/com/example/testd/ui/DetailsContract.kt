package com.example.testd.ui

import com.example.domain.repository.entity.Country

interface DetailsContract {

    interface Presenter{

        fun bindView(view: View)

        fun onCountryClicked(code: String)
    }

    interface View : BaseView{
        fun showCountry(country: Country?)
    }
}