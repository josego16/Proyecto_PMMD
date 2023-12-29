package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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
                val spinnerName = getSpinnerName()
                navController.navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailsFragment(name = spinnerName)
                )
            }
            val listDigimons =
                arrayOf("", "Takutoumon", "Shortmon", "ClearAgumon", "Loogamon", "Chamblemon")
            val adapter = arrayAdapter(listDigimons)
            binding.idSpHome.adapter = adapter

            binding.idSpHome.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
        }
    }

    private fun getSpinnerName(): String {
        val position = binding.idSpHome.selectedItemPosition
        return if (position != 0) {
            binding.idSpHome.getItemAtPosition(position).toString()
        } else {
            "No digimon selected"
        }
    }

    private fun arrayAdapter(listDigimons: Array<String>): ArrayAdapter<String> {
        return ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            listDigimons
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
    }
}