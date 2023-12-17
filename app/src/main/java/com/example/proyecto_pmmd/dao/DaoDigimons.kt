package com.example.proyecto_pmmd.dao

import com.example.proyecto_pmmd.interfaces.InterfazDao
import com.example.proyecto_pmmd.models.Digimon
import com.example.proyecto_pmmd.objects_models.Repository

class DaoDigimons private constructor() : InterfazDao {
    companion object {
        val mydao: DaoDigimons by lazy {
            DaoDigimons()
        }
    }

    override fun getDataDigimons(): List<Digimon> = Repository.list_Digimon
}