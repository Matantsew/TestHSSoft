package com.example.testd.ui

import com.example.domain.repository.entity.Country

interface ListCountriesContract {

    interface View : BaseView{

        fun showList(countries: List<Country>)
    }

    interface Presenter {

        fun bindView(view: View)

        fun initUI()

        fun unbindView()
    }
}