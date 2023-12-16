package com.example.proyecto_pmmd.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_pmmd.databinding.ActivityIntentRegisterBinding

class ActivityIntentRegister : AppCompatActivity() {
    private lateinit var binding: ActivityIntentRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}