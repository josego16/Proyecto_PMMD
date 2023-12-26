package com.example.proyecto_pmmd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.ActivityLoginBinding
import com.example.proyecto_pmmd.databinding.FragmentRecyclerBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var recyclerBinding: FragmentRecyclerBinding
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerBinding = FragmentRecyclerBinding.inflate(layoutInflater)

        init()
    }

    private fun init() {
        controller =
            Controller(
                this,
                recyclerBinding
            ) // Pasa el contexto y binding al constructor de Controller
        controller.setActionEvent()
    }
}