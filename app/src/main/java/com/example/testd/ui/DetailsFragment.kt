package com.example.testd.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.coroutines.await
import com.example.data.apolloClient
import com.example.domain.repository.entity.Country
import com.example.testd.GetCountriesQuery
import com.example.testd.GetCountryQuery
import com.example.testd.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(){

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

    interface OnUpdateCountryInfo{
        fun onUpdate(countryCode: String)
    }
}