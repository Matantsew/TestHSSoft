package com.example.testd.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.repository.entity.Country
import com.example.testd.databinding.CountryRowBinding
import com.example.testd.ui.DetailsFragment

class CountriesListAdapter(private val countries: List<Country>, private val onUpdateCountryInfo: DetailsFragment.OnUpdateCountryInfo) : RecyclerView.Adapter<CountriesListAdapter.CountriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(CountryRowBinding.inflate(LayoutInflater.from(parent.context)), onUpdateCountryInfo)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
         val item = countries[position]
         val country = Country(name = item.name, code = item.code)
         holder.bind(country, position + 1)
    }

    class CountriesViewHolder(itemView: CountryRowBinding, private val onUpdateCountryInfo: DetailsFragment.OnUpdateCountryInfo) : RecyclerView.ViewHolder(itemView.root){

        private var binding = itemView

        fun bind(country: Country, number: Int){
            val numberText = "$number."
            binding.number.text = numberText
            binding.countryName.text = country.name

            binding.root.setOnClickListener {
                onUpdateCountryInfo.onUpdate(country.code)
            }
        }
    }
}