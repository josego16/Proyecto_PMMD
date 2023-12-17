package com.example.proyecto_pmmd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()
        initBotones()
        cargarDatos()
    }

    private fun initBotones() {
        binding.idBtnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Metodos utilizados para el CRUD (crear, editar y elimnar).
     */

    private fun initEvent() {
        initRecyclerView()
        controller = Controller(this)
        controller.setAdapter()
        controller.loggOut()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Metodos utilizados para el Login & Registro.
     */

    private fun cargarDatos() {
        val bundle = intent.extras
        if (bundle != null) {
            val username = bundle.getString("username")
            val password = bundle.getString("password")
        }
    }
}