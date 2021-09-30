package com.example.testd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.domain.repository.entity.Country
import com.example.testd.di.DaggerListCountriesComponent
import com.example.testd.di.ListCountriesComponent
import com.example.testd.ui.DetailsFragment
import com.example.testd.ui.ListContinentsFragment
import com.example.testd.ui.ListCountriesPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), DetailsFragment.OnUpdateCountryInfo{

    private lateinit var detailsFragment: DetailsFragment
    private lateinit var component: ListCountriesComponent

    @Inject
    lateinit var presenter: ListCountriesPresenter

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

        lifecycleScope.launchWhenResumed {
            val country = presenter.obtainCountryByCode(countryCode)
            detailsFragment.setCountryName(country!!.name)
            detailsFragment.setCountryNat(country.nat)
            detailsFragment.setCountryCapital(country.capital)
            detailsFragment.setCountryFlag(country.flag)
        }
    }
}