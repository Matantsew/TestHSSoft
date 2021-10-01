package com.example.testd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testd.di.DaggerListCountriesComponent
import com.example.testd.di.ListCountriesComponent
import com.example.testd.ui.DetailsFragment
import com.example.testd.ui.DetailsPresenter
import com.example.testd.ui.ListContinentsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), DetailsFragment.OnUpdateCountryInfo {

    private lateinit var detailsFragment: DetailsFragment
    private lateinit var component: ListCountriesComponent

    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        component = DaggerListCountriesComponent.create()
        component.inject(this)

        detailsFragment = DetailsFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.left_container, ListContinentsFragment())
            .replace(R.id.right_container, detailsFragment)
            .commit()
    }

    override fun onUpdate(countryCode: String) {
        
    }
}