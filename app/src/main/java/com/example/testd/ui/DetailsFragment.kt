package com.example.testd.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.domain.repository.entity.Country
import com.example.testd.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(), DetailsContract.View{

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentDetailsBinding.inflate(inflater)

        return binding.root
    }

    fun setCountryName(name: String){
        binding.countryText.text = name
    }

    fun setCountryNat(nat: String?){
        binding.natText.text = nat
    }

    fun setCountryCapital(capital: String?){
        binding.capitalText.text = capital
    }

    fun setCountryFlag(flag: String?){
        binding.flagText.text = flag
    }

    override fun showCountry(country: Country?) {
        if (country != null) {
            setCountryName(country.name)
            setCountryNat(country.nat)
            setCountryCapital(country.capital)
            setCountryFlag(country.flag)
        }
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    interface OnUpdateCountryInfo{
        fun onUpdate(countryCode: String)
    }
}