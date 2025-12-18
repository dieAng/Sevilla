package com.example.sevilla.ui.screens

import androidx.lifecycle.ViewModel
import com.example.sevilla.model.SevillaItem.*
import com.example.sevilla.model.SevillaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * El ViewModel para la aplicación de Sevilla.
 */
class SevillaViewModel : ViewModel() {
    /**
     * El estado de la interfaz de usuario para la aplicación de Sevilla.
     */
    private val _uiState = MutableStateFlow(SevillaUiState())
    val uiState: StateFlow<SevillaUiState> = _uiState.asStateFlow()

    /**
     * Actualiza la categoría actual.
     *
     * @param categoria La nueva categoría actual.
     */
    fun updateCurrentCategoria(categoria: Categoria) {
        _uiState.value = _uiState.value.copy(currentCategoria = categoria)
    }

    /**
     * Actualiza el lugar actual.
     *
     * @param lugar El nuevo lugar actual.
     */
    fun updateCurrentLugar(lugar: Lugar) {
        _uiState.value = _uiState.value.copy(currentLugar = lugar)
    }

    /**
     * Restablece la categoría actual a nulo.
     */
    fun resetCurrentCategoria() {
        _uiState.value = _uiState.value.copy(currentCategoria = null)
    }

    /**
     * Restablece el lugar actual a nulo.
     */
    fun resetCurrentLugar() {
        _uiState.value = _uiState.value.copy(currentLugar = null)
    }
}