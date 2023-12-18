package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.databinding.ActivityDialogDigimonBinding
import com.example.proyecto_pmmd.models.Digimon

class DialogNewDigimon(
    val onNewDigimonDialog: (Digimon) -> Unit
) : DialogFragment() {
    private lateinit var onDialogPositiveClick: (String, String, String, String) -> Unit
    private lateinit var onDialogNegativeClick: (String) -> Unit
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(activity)
            val inflater = requireActivity().layoutInflater

            val viewDialogNewDigimon = inflater.inflate(R.layout.activity_dialog_digimon, null)
            builder.setView(viewDialogNewDigimon)

            builder.setPositiveButton("Añadir") { dialog, id ->
                val binding = ActivityDialogDigimonBinding.bind(viewDialogNewDigimon)
                val newDigimon = recoverDataLayout(viewDialogNewDigimon) as Digimon
                if (
                    newDigimon.name.isEmpty() ||
                    newDigimon.level.isEmpty() ||
                    newDigimon.type.isEmpty() ||
                    newDigimon.attribute.isEmpty()
                ) {
                    Toast.makeText(activity,"No puede haber ningun campo vacio",Toast.LENGTH_SHORT).show()
                    getDialog()?.cancel()
                } else {
                    onNewDigimonDialog(newDigimon)
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, id ->
                Toast.makeText(context, "Has cancelado la accion", Toast.LENGTH_SHORT).show()
                getDialog()?.cancel()
            }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    private fun recoverDataLayout(view: View): Any {
        val binding = ActivityDialogDigimonBinding.bind(view)
        return Digimon(
            binding.idDialogEtName.text.toString(),
            binding.idDialogEtLevel.text.toString(),
            binding.idDialogEtType.text.toString(),
            binding.idDialogEtAttribute.text.toString(),
            binding.idImgDialog.id.toString()
        )
    }
}
