package com.example.sevilla.ui

import androidx.lifecycle.ViewModel
import com.example.sevilla.model.SevillaUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SevillaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SevillaUiState())
    val uiState: StateFlow<SevillaUiState> = _uiState.asStateFlow()
}