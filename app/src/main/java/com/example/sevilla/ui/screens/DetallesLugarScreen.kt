package com.example.sevilla.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sevilla.model.SevillaItem

@Composable
fun DetallesLugarScreen(
    lugar: SevillaItem.Lugar?,
    modifier: Modifier = Modifier,
) {
    Column {
        Image(
            painter = painterResource(lugar?.imagen ?: 0),
            contentDescription = null
        )

        Text(
            text = lugar?.descripcion ?: "",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
fun DetallesLugarPreview() {
}