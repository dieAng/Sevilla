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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sevilla.data.DataSource
import com.example.sevilla.model.SevillaItem.Categoria

/**
 * Una pantalla componible que muestra una lista de categorías.
 *
 * @param categorias La lista de categorías a mostrar.
 * @param onCategoriaClick La función a la que se llamará cuando se haga clic en una categoría.
 */
@Composable
fun CategoriaScreen(
    categorias: List<Categoria> = DataSource.categorias,
    onCategoriaClick: (Categoria) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categorias) { categoria ->
            CategoriaItem(
                categoria = categoria,
                onCategoriaClick = onCategoriaClick
            )
        }
    }
}

/**
 * Un elemento componible que muestra una sola categoría.
 *
 * @param categoria La categoría a mostrar.
 * @param onCategoriaClick La función a la que se llamará cuando se haga clic en la categoría.
 */
@Composable
fun CategoriaItem(
    categoria: Categoria,
    onCategoriaClick: (Categoria) -> Unit
) {
    Card(
        onClick = { onCategoriaClick(categoria) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(bottomEnd = 30.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(categoria.imagen),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )

            Text(
                text = stringResource(categoria.nombre),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

/**
 * Una vista previa componible para la pantalla de categorías.
 */
@Preview(showBackground = true)
@Composable
fun CategoriaScreenPreview() {
    CategoriaScreen(
        onCategoriaClick = {  }
    )
}
