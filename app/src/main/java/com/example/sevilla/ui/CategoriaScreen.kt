package com.example.sevilla.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sevilla.data.DataSource
import com.example.sevilla.model.SevillaItem

@Composable
fun CategoriaScreen(
    categorias: List<SevillaItem.Categoria> = DataSource.categorias,
    onCategoriaClick: (SevillaItem.Categoria) -> Unit,
) {

}

@Preview
@Composable
fun CategoriaScreenPreview() {
}