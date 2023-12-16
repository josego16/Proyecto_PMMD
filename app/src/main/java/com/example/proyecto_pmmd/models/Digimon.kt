package com.example.proyecto_pmmd.models

class Digimon(
    private var name: String,
    private var level: String,
    private var type: String,
    private var attribute: String,
    private var imagen: String
) {
    override fun toString(): String {
        return "Digimon(name='$name', level='$level', type='$type', attribute='$attribute', imagen='$imagen')"
    }
}