package com.example.sevilla.model

import com.example.sevilla.data.DataSource

/**
 * Una clase de datos que representa el estado de la interfaz de usuario para la aplicación de Sevilla.
 *
 * @property categorias La lista de todas las categorías.
 * @property currentCategoria La categoría actualmente seleccionada.
 * @property currentLugar El lugar actualmente seleccionado.
 */
data class SevillaUiState(
    val categorias: List<SevillaItem.Categoria> = DataSource.categorias,
    val currentCategoria: SevillaItem.Categoria? = null,
    val currentLugar: SevillaItem.Lugar? = null
)
