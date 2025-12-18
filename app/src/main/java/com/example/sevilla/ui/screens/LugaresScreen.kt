package com.example.sevilla.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sevilla.data.DataSource
import com.example.sevilla.model.SevillaItem

/**
 * Una pantalla componible que muestra una lista de lugares.
 *
 * @param lugares La lista de lugares a mostrar.
 * @param onLugarClick La función a la que se llamará cuando se haga clic en un lugar.
 * @param modifier El modificador que se aplicará a la pantalla.
 */
@Composable
fun LugaresScreen(
    lugares: List<SevillaItem.Lugar>,
    onLugarClick: (SevillaItem.Lugar) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(lugares) { lugar ->
            LugarItem(
                lugar = lugar,
                onLugarClick = onLugarClick,
            )
        }
    }
}

/**
 * Un elemento componible que muestra un solo lugar.
 *
 * @param lugar El lugar a mostrar.
 * @param onLugarClick La función a la que se llamará cuando se haga clic en el lugar.
 */
@Composable
fun LugarItem(
    lugar: SevillaItem.Lugar,
    onLugarClick: (SevillaItem.Lugar) -> Unit) {
    Card(
        onClick = { onLugarClick(lugar) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(bottomEnd = 30.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(lugar.imagen),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(lugar.nombre),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

/**
 * Una vista previa componible para la pantalla de lugares.
 */
@Preview
@Composable
fun LugaresScreenPreview() {
    LugaresScreen(
        lugares = DataSource.categorias[0].lugares,
        onLugarClick = {}
    )
}
