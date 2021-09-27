package com.example.testd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testd.databinding.FragmentListContinentsBinding

class ListContinentsFragment : Fragment(){

    private lateinit var binding: FragmentListContinentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentListContinentsBinding.inflate(inflater)

        return binding.root
    }

}