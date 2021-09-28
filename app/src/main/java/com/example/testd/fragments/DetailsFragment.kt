package com.example.testd.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo.coroutines.await
import com.example.data.apolloClient
import com.example.testd.FetchCountriesQuery
import com.example.testd.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(){

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentDetailsBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(FetchCountriesQuery()).await()

            val data = response.data
            if (data != null && !response.hasErrors()) {
                binding.capitalText.text = data.country?.capital
            }

            Log.d("Countries", "Success ${response.data}")
        }
    }
}