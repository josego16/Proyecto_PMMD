package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
        navHost.let {
            navController = navHost!!.findNavController()

            binding.idBtnData1.setOnClickListener {}
            binding.idBtnData2.setOnClickListener {}
            binding.idBtnData3.setOnClickListener {}
            binding.idBtnData4.setOnClickListener {}
        }
    }
}