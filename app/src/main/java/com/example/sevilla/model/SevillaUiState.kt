package com.example.sevilla.model

data class SevillaUiState(
    val categorias: List<SevillaItem.Categoria> = emptyList(),
    val currentCategoria: SevillaItem.Categoria? = null,
    val currentLugar: SevillaItem.Lugar? = null
)
