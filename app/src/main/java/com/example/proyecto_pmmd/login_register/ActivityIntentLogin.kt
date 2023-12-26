package com.example.proyecto_pmmd.login_register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_pmmd.databinding.ActivityIntentLoginBinding

class ActivityIntentLogin : AppCompatActivity() {
    lateinit var binding: ActivityIntentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}