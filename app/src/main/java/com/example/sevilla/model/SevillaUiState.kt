package com.example.sevilla.model

import com.example.sevilla.data.DataSource

data class SevillaUiState(
    val categorias: List<SevillaItem.Categoria> = DataSource.categorias,
    val currentCategoria: SevillaItem.Categoria? = null,
    val currentLugar: SevillaItem.Lugar? = null
)
