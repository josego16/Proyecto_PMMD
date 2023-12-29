package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.proyecto_pmmd.databinding.FragmentData1Binding

class Data1Fragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentData1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentData1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }
}