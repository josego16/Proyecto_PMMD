package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
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
        //Tengo que cambiar activity por myActivity
        return activity?.let {
            // Build the dialog and set up the button click handlers
            val intentLogin = Intent(context, MainActivity::class.java)
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            val viewDialogLogin = inflater.inflate(R.layout.activity_intent_login, null)
            builder.setView(viewDialogLogin)

            builder.setMessage("Datos Login")
            builder.setPositiveButton("Guardar") { dialog, id ->
                // Send the positive button event back to the host activity
                val binding = ActivityIntentLoginBinding.bind(viewDialogLogin)
                onDialogPositiveClick(
                    binding.idEtUsernameLogin.text.toString(),
                    binding.idEtPasswordLogin.text.toString()
                )
                val bundle = Bundle()
                bundle.putString("username", binding.idEtUsernameLogin.text.toString())
                bundle.putString("Password", binding.idEtPasswordLogin.text.toString())
                intentLogin.putExtras(bundle)
                startActivity(intentLogin)
            }
                .setNegativeButton(
                    "Cancelar"
                ) { dialog, id ->
                    // Send the negative button event back to the host activity
                    onDialogNegativeClick("Se ha cancelado")
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}