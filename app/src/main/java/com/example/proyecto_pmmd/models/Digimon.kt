package com.example.proyecto_pmmd.models

class Digimon(
    var name: String,
    var level: String,
    var type: String,
    var attribute: String,
    var imagen: String
) {
    override fun toString(): String {
        return "Digimon(name='$name', level='$level', type='$type', attribute='$attribute', imagen='$imagen')"
    }
}