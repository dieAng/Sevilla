package com.example.sevilla.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class SevillaItem {
    data class Categoria(
        @StringRes val nombre: Int,
        val lugares: List<Lugar>,
        @DrawableRes val imagen: Int
    )

    data class Lugar(
        @StringRes val nombre: Int,
        @StringRes val descripcion: Int?,
        @StringRes val ubicacion: Int,
        @DrawableRes val imagen: Int
    )
}