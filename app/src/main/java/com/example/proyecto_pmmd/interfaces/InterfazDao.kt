package com.example.proyecto_pmmd.interfaces

import com.example.proyecto_pmmd.models.Digimon
import com.example.proyecto_pmmd.objects_models.Repository

interface InterfazDao {
    fun getDataDigimons(): List<Digimon> = Repository.list_Digimon
}