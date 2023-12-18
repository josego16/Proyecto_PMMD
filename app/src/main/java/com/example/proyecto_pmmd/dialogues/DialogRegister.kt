package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmmd.LoginActivity
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.ActivityIntentRegisterBinding

class DialogRegister(
    private val controller: Controller,
    val onDialogPositiveClick: (String, String, String, String, String) -> Unit,
    val onDialogNegativeClick: (String) -> Unit
) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val intentRegister = Intent(context, LoginActivity::class.java)
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            // Pass null as the parent view because its going in the dialog layout
            val viewDialogRegister = inflater.inflate(R.layout.activity_intent_register, null)
            builder.setView(viewDialogRegister)

            builder.setMessage("Datos Registro")
            builder.setPositiveButton("Guardar") { dialog, id ->
                // Send the positive button event back to the host activity
                val binding = ActivityIntentRegisterBinding.bind(viewDialogRegister)
                val fullName = binding.idEtFullNameRegister.text.toString()
                val email = binding.idEtEmailRegister.text.toString()
                val username = binding.idEtUsernameRegister.text.toString()
                val password = binding.idEtPasswordRegister.text.toString()
                val confirmPassword = binding.idEtConfirmPasswordRegister.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && password == confirmPassword) {
                    if (validarDatos(fullName, email, username, password, confirmPassword)) {
                        onDialogPositiveClick(fullName, email, username, password, confirmPassword)
                        val bundle = Bundle()
                        bundle.putString("fullname", fullName)
                        bundle.putString("email", email)
                        bundle.putString("username", username)
                        bundle.putString("password", password)
                        bundle.putString("confirmPassword", confirmPassword)
                        intentRegister.putExtras(bundle)

                        startActivity(intentRegister)
                    }
                } else {
                    // Inform the user that the data is invalid
                    Toast.makeText(context, "Datos inválidos", Toast.LENGTH_SHORT).show()
                }
            }
            builder.setNegativeButton(
                "Cancelar"
            ) { dialog, id ->
                // Send the negative button event back to the host activity
                onDialogNegativeClick("Se ha cancelado")
            }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun validarDatos(
        fullname: String,
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (fullname.isEmpty()) {
            Toast.makeText(context, "Formato incorrecto", Toast.LENGTH_SHORT).show()
        } else {
            val regex = "^[A-Za-z][A-Za-z0-9 ]*$"
            return fullname.matches(Regex(regex))
        }
        if (email.isEmpty()) {
            Toast.makeText(context, "Formato incorrecto", Toast.LENGTH_SHORT).show()
        } else {
            val regex =
                "^[A-Za-z][A-Za-z0-9+\\-]+(\\.[A-Za-z0-9+\\-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
            return email.matches(Regex(regex))
        }
        if (username.isEmpty()) {
            Toast.makeText(context, "Formato incorrecto", Toast.LENGTH_SHORT).show()
        } else {
            val regex = "^[A-Za-z][A-Za-z0-9]*$"
            return username.matches(Regex(regex))
        }
        if (password.isEmpty()) {
            Toast.makeText(context, "Formato incorrecto", Toast.LENGTH_SHORT).show()
        } else {
            val regex = "^[A-Za-z][A-Za-z0-9]*$"
            return password.matches(Regex(regex))
        }
        if (confirmPassword.isEmpty()) {
            Toast.makeText(context, "Formato incorrecto", Toast.LENGTH_SHORT).show()
        } else {
            return password == confirmPassword
        }
        return true
    }
}