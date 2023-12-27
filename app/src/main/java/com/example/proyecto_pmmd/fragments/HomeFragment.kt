package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
        navHost.let {
            navController = navHost!!.findNavController()

            binding.idBtnHomeNext.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_detailsFragment)
            }
        }
    }
}