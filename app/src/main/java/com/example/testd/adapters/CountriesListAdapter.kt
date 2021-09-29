package com.example.testd.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.repository.entity.Country
import com.example.testd.GetCountriesQuery
import com.example.testd.databinding.CountryRowBinding
import com.example.testd.ui.ListCountriesPresenter
import javax.inject.Inject

class CountriesListAdapter(val countries: List<Country>) : RecyclerView.Adapter<CountriesListAdapter.CountriesViewHolder>() {

    @Inject
    lateinit var presenter: ListCountriesPresenter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(CountryRowBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
         val item = countries[position]
         val country = Country(name = item.name, code = item.code)
         holder.bind(country, position + 1)
    }

    class CountriesViewHolder(itemView: CountryRowBinding) : RecyclerView.ViewHolder(itemView.root){

        private var binding = itemView

        fun bind(country: Country, number: Int){
            val numberText = "$number."
            binding.number.text = numberText
            binding.countryName.text = country.name

            binding.root.setOnClickListener {
                country.code
            }
        }
    }
}