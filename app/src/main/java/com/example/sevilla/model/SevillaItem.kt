package com.example.sevilla.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Una clase que representa los elementos de la aplicación de Sevilla.
 */
class SevillaItem {
    /**
     * Una clase de datos que representa una categoría.
     *
     * @property nombre El ID del recurso de cadena para el nombre de la categoría.
     * @property lugares La lista de lugares de la categoría.
     * @property imagen El ID del recurso dibujable para la imagen de la categoría.
     */
    data class Categoria(
        @StringRes val nombre: Int,
        val lugares: List<Lugar>,
        @DrawableRes val imagen: Int
    )

    /**
     * Una clase de datos que representa un lugar.
     *
     * @property nombre El ID del recurso de cadena para el nombre del lugar.
     * @property descripcion El ID del recurso de cadena para la descripción del lugar.
     * @property ubicacion El ID del recurso de cadena para la ubicación del lugar.
     * @property imagen El ID del recurso dibujable para la imagen del lugar.
     */
    data class Lugar(
        @StringRes val nombre: Int,
        @StringRes val descripcion: Int?,
        @StringRes val ubicacion: Int,
        @DrawableRes val imagen: Int
    )
}