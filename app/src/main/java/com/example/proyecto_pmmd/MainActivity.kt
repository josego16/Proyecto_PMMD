package com.example.proyecto_pmmd

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initHandler()
        initEvent()
        initBotones()
        cargarDatos()
    }

    private fun initHandler() {
        handler = Handler(Looper.getMainLooper())
        binding.progressBar.visibility = View.VISIBLE
        binding.idRecyclerView.visibility = View.GONE

        handler.postDelayed({
            binding.progressBar.visibility = View.GONE
            binding.idRecyclerView.visibility = View.VISIBLE
        }, 3000)
    }

    /**
     * Metodos utilizados para el CRUD (crear, editar y elimnar).
     */

    private fun initEvent() {
        initRecyclerView()
        controller = Controller(this)
        controller.setAdapter()
        /*controller.loggOut()*/
    }

    private fun initBotones() {
        binding.idBtnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
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