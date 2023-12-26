package com.example.proyecto_pmmd.dialogues

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.proyecto_pmmd.MainActivity
import com.example.proyecto_pmmd.R
import com.example.proyecto_pmmd.databinding.ActivityDialogDigimonBinding
import com.example.proyecto_pmmd.databinding.ItemlistCardviewBinding
import com.example.proyecto_pmmd.models.ArgumentsDigimon
import com.example.proyecto_pmmd.models.Digimon

class DialogEditDigimon(
    private val digimonToUpdate: Digimon) : DialogFragment() {
    private lateinit var updateDigimonDialog: (Digimon) -> Unit
    private lateinit var activity: MainActivity

    private val ARGUMENT_NAME: String = ArgumentsDigimon.ARGUMENT_NAME
    private val ARGUMENT_LEVEL: String = ArgumentsDigimon.ARGUMENT_LEVEL
    private val ARGUMENT_TYPE: String = ArgumentsDigimon.ARGUMENT_TYPE
    private val ARGUMENT_ATTRIBUTE: String = ArgumentsDigimon.ARGUMENT_ATTRIBUTE
    private val ARGUMENT_IMAGE: String = ArgumentsDigimon.ARGUMENT_IMAGE

    init {
        val args = Bundle().apply {
            putString(ARGUMENT_NAME, digimonToUpdate.name)
            putString(ARGUMENT_LEVEL, digimonToUpdate.level)
            putString(ARGUMENT_TYPE, digimonToUpdate.type)
            putString(ARGUMENT_ATTRIBUTE, digimonToUpdate.attribute)
            putString(ARGUMENT_IMAGE, digimonToUpdate.imagen)
        }
        this.arguments = args
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(activity)
            val inflater = requireActivity().layoutInflater

            val viewDialogEditDigimon = inflater.inflate(R.layout.activity_dialog_digimon, null)
            setValuesIntoDialog(viewDialogEditDigimon, this.arguments)

            builder.setView(viewDialogEditDigimon)
            builder.setMessage("Editar Datos")
            builder.setPositiveButton("Aceptar")
            { dialog, id ->
                val binding = ActivityDialogDigimonBinding.bind(viewDialogEditDigimon)
                val updateDigimon = recoverDataLayout(viewDialogEditDigimon) as Digimon
                if (
                    updateDigimon.name.isEmpty() ||
                    updateDigimon.level.isEmpty() ||
                    updateDigimon.type.isEmpty() ||
                    updateDigimon.attribute.isEmpty()
                ) {
                    Toast.makeText(
                        activity,
                        "Existen todavia campos vacios",
                        Toast.LENGTH_SHORT
                    ).show()
                    getDialog()?.cancel()
                } else {
                    updateDigimonDialog(updateDigimon)
                }
            }
            builder.setNegativeButton("Cancelar") { dialog, id ->
                getDialog()?.cancel()
            }

            builder.create()
        } ?: throw IllegalStateException("Activty cannot be null")
    }

    private fun recoverDataLayout(view: View): Any {
        val binding = ItemlistCardviewBinding.bind(view)
        return Digimon(
            binding.textName.text.toString(),
            binding.textLevel.text.toString(),
            binding.textType.text.toString(),
            binding.textAttribute.text.toString(),
            binding.idImgPpal.isInLayout.toString()
        )
    }

    private fun setValuesIntoDialog(viewDialogEditHotel: View, arguments: Bundle?) {
        val binding = ItemlistCardviewBinding.bind(viewDialogEditHotel)
        if (arguments != null) {
            binding.textName.text = arguments.getString(ARGUMENT_NAME)
            binding.textLevel.text = arguments.getString(ARGUMENT_NAME)
            binding.textType.text = arguments.getString(ARGUMENT_TYPE)
            binding.textAttribute.text = arguments.getString(ARGUMENT_ATTRIBUTE)

            Glide.with(activity)
                .load(digimonToUpdate.imagen)
                .centerCrop()
                .into(binding.idImgPpal)
        }
    }
}
