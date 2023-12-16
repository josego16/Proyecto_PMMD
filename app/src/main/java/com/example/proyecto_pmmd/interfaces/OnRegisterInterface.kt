package com.example.proyecto_pmmd.interfaces

import androidx.fragment.app.DialogFragment

interface OnRegisterInterface {
    fun onDialogPositiveClick(dialog: DialogFragment?)
    fun onDialogNegativeClick(dialog: DialogFragment?)
}