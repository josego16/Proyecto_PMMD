package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmmd.MainActivity
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.ActivityIntentLoginBinding

class DialogLogin(
    val controller: Controller,
    val onDialogPositiveClick: (String, String) -> Unit,
    val onDialogNegativeClick: (String) -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val intentLogin = Intent(context, MainActivity::class.java)
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val viewDialogLogin = inflater.inflate(R.layout.activity_intent_login, null)
            builder.setView(viewDialogLogin)

            builder.setMessage("Datos Login")
            builder.setPositiveButton("Guardar") { dialog, id ->
                val binding = ActivityIntentLoginBinding.bind(viewDialogLogin)
                if (isValidUser(
                        binding.idEtUsernameLogin.text.toString(),
                        binding.idEtPasswordLogin.text.toString())
                    ) {
                    onDialogPositiveClick(
                        binding.idEtUsernameLogin.text.toString(),
                        binding.idEtPasswordLogin.text.toString()
                    )
                    val bundle = Bundle()
                    bundle.putString("username", binding.idEtUsernameLogin.text.toString())
                    bundle.putString("Password", binding.idEtPasswordLogin.text.toString())
                    intentLogin.putExtras(bundle)
                    startActivity(intentLogin)
                } else {
                    Toast.makeText(context, "El usuario es incorrecto", Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, id ->
                onDialogNegativeClick("Se ha cancelado")
            }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun isValidUser(username: String, password: String): Boolean {
        return username == "jgomlin" && password == "dam2324"
    }
}