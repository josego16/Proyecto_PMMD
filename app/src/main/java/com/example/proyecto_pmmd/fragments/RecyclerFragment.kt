package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.FragmentRecyclerBinding

class RecyclerFragment : Fragment() {
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