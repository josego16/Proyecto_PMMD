package com.example.proyecto_pmmd.interfaces

import androidx.fragment.app.DialogFragment

interface OnLoginInterface {
    fun onDialogPositiveClick(dialog: DialogFragment?)
    fun onDialogNegativeClick(dialog: DialogFragment?)
}