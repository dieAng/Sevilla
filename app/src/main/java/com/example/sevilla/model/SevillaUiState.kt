package com.example.sevilla.model

data class SevillaUiState(
    val categorias: List<SevillaItem.Categoria> = emptyList(),
    val lugares: List<SevillaItem.Lugar> = emptyList(),
    val currentCategoria: SevillaItem.Lugar? = null,
    val currentLugar: SevillaItem.Lugar? = null
)
