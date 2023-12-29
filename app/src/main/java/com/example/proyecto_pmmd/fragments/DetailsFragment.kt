package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentDetailsBinding
    private val myArguments: DetailsFragmentArgs by navArgs()

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
        val spinnerString = myArguments.name
        binding.idTvDetailsRespuesta.text = spinnerString
        val navHost = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
        navHost.let {
            navController = navHost!!.findNavController()

            binding.idBtnData1.setOnClickListener {
                navController.navigate(R.id.action_detailsFragment_to_data1Fragment)
            }
            binding.idBtnData2.setOnClickListener {
                navController.navigate(R.id.action_detailsFragment_to_data2Fragment)
            }
            binding.idBtnData3.setOnClickListener {
                navController.navigate(R.id.action_detailsFragment_to_data3Fragment)
            }
            binding.idBtnData4.setOnClickListener {
                navController.navigate(R.id.action_detailsFragment_to_data4Fragment)
            }
        }
    }
}