package com.example.testd.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo.coroutines.await
import com.example.data.apolloClient
import com.example.testd.GetCountriesQuery
import com.example.testd.adapters.CountriesListAdapter
import com.example.testd.databinding.FragmentListContinentsBinding
import com.example.testd.di.DaggerListCountriesComponent
import com.example.testd.di.ListCountriesComponent
import javax.inject.Inject

class ListContinentsFragment : Fragment(), ListCountriesContract.View{

    private lateinit var binding: FragmentListContinentsBinding
    private lateinit var component: ListCountriesComponent

    @Inject
    lateinit var presenter: ListCountriesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentListContinentsBinding.inflate(inflater)

        component = DaggerListCountriesComponent.create()
        component.inject(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            initializeList()
        }
    }

    override suspend fun initializeList(){

        val countries = presenter.fetchListOfCountries()

        binding.listContinents.layoutManager = LinearLayoutManager(context)
        binding.listContinents.adapter = CountriesListAdapter(countries!!)
        binding.listContinents.setHasFixedSize(true)
    }
}