package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmmd.MainActivity
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.controller.Controller
import com.example.proyecto_pmmd.databinding.ActivityIntentRegisterBinding

class DialogRegister(
    val controller: Controller,
    val onDialogPositiveClick: (String, String, String, String, String) -> Unit,
    val onDialogNegativeClick: (String) -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val intentRegister = Intent(context, MainActivity::class.java)
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            // Pass null as the parent view because its going in the dialog layout
            val viewDialogRegister = inflater.inflate(R.layout.activity_intent_register, null)
            builder.setView(viewDialogRegister)

            builder.setMessage("Datos Registro")
            builder.setPositiveButton("Guardar") { dialog, id ->
                // Send the positive button event back to the host activity
                val binding = ActivityIntentRegisterBinding.bind(viewDialogRegister)
                onDialogPositiveClick(
                    binding.idEtFullNameRegister.text.toString(),
                    binding.idEtEmailRegister.text.toString(),
                    binding.idEtUsernameRegister.text.toString(),
                    binding.idEtPasswordRegister.text.toString(),
                    binding.idEtConfirmPasswordRegister.text.toString()
                )
                val bundle = Bundle()
                bundle.putString("fullname", binding.idEtFullNameRegister.text.toString())
                bundle.putString("email", binding.idEtEmailRegister.text.toString())
                bundle.putString("username", binding.idEtUsernameRegister.text.toString())
                bundle.putString("password", binding.idEtPasswordRegister.text.toString())
                bundle.putString(
                    "confirmPassword",
                    binding.idEtConfirmPasswordRegister.text.toString()
                )
                intentRegister.putExtras(bundle)

                startActivity(intentRegister)
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