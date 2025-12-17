package com.example.sevilla.model

class SevillaItem {
    data class Categoria(
        val nombre: Int,
        val lugares: List<Lugar>,
        val imagen: Int
    )

    data class Lugar(
        val nombre: Int,
        val descripcion: Int?,
        val imagen: Int
    )
}