package com.example.sevilla.model

class SevillaItem {
    data class Categoria(
        val nombre: String,
        val descripcion: String,
        val lugares: List<Lugar>,
        val imagen: Int
    )

    data class Lugar(
        val nombre: String,
        val descripcion: String,
        val imagen: Int
    )

    data class DetallesLugar(
        val descripcion: String,
        val imagen: Int
    )
}