package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentRecyclerBinding
    private lateinit var controller: Controller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerBinding.inflate(layoutInflater, container, false)
        initEvent()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navhost = requireActivity()
            .supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
        navhost.let {
            navController = navhost!!.findNavController()
        }
    }

    private fun initEvent() {
        initRecyclerView()
        // Inicializa Controller aquí
        controller = Controller(requireContext(), binding)
        controller.setAdapter()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(activity)
    }
}