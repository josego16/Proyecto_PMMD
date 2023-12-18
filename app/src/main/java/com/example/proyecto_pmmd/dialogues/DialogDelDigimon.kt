package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogDelDigimon(
    val onDialogPositiveClick: (String, String, String, String) -> Unit,
    val onDialogNegativeClick: (String) -> Unit, private val pos: Int,
    val name: String,
    val onDeleteDigiDialog: (Int) -> Unit
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val buiilder = AlertDialog.Builder(activity)

            buiilder.setMessage("Deseas borrar el digimon $name")
            buiilder.setPositiveButton("Si") { dialog, id ->
                onDeleteDigiDialog(pos)
            }
            buiilder.setNegativeButton("No") { dialog, id ->
                onDialogNegativeClick("Se ha cancelado")
                dialog.dismiss()
            }

            buiilder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}