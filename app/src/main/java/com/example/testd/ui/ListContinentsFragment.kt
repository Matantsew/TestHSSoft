package com.example.testd.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.repository.entity.Country
import com.example.testd.adapters.CountriesListAdapter
import com.example.testd.databinding.FragmentListContinentsBinding
import com.example.testd.di.DaggerListCountriesComponent
import com.example.testd.di.ListCountriesComponent
import javax.inject.Inject

class ListContinentsFragment : Fragment(), ListCountriesContract.View{

    private var binding: FragmentListContinentsBinding? = null
    private lateinit var component: ListCountriesComponent
    private lateinit var onUpdateCountryInfo: DetailsFragment.OnUpdateCountryInfo

    @Inject
    lateinit var presenter: ListCountriesPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onUpdateCountryInfo = context as DetailsFragment.OnUpdateCountryInfo
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentListContinentsBinding.inflate(inflater).let {
            component = DaggerListCountriesComponent.create()
            component.inject(this)
            binding = it
           return@let it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bindView(this)
        presenter.initUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        presenter.unbindView()
    }

    override fun showList(countries: List<Country>) {
        binding?.run {
            listContinents.layoutManager = LinearLayoutManager(context)
            listContinents.adapter = CountriesListAdapter(countries, onUpdateCountryInfo)
            listContinents.setHasFixedSize(true)
        }
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showError() {
        TODO("Not yet implemented")
    }
}