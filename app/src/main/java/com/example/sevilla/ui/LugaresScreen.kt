package com.example.sevilla.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sevilla.model.SevillaItem

@Composable
fun LugaresScreen(
    lugares: List<SevillaItem.Lugar>,
    onLugarClick: (SevillaItem.Lugar) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn {
        items(lugares) { lugar ->
            LugarItem(
                lugar = lugar,
                onLugarClick = onLugarClick,
            )
        }
    }
}

@Composable
fun LugarItem(
    lugar: SevillaItem.Lugar,
    onLugarClick: (SevillaItem.Lugar) -> Unit) {
    Card(
        onClick = { onLugarClick(lugar) },
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    ){
        Image(
            painter = painterResource(lugar.imagen),
            contentDescription = null
        )

        Text(
            text = "",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun LugaresScreenPreview() {
}