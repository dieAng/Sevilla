package com.example.sevilla.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sevilla.model.SevillaItem

@Composable
fun LugaresScreen(
    lugares: List<SevillaItem.Lugar>,
    onLugarClick: (SevillaItem.Lugar) -> Unit,
    modifier: Modifier = Modifier,
) {

}

@Preview
@Composable
fun LugaresScreenPreview() {
}