package com.example.sevilla.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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

@Composable
fun DetallesLugarScreen(
    lugar: SevillaItem.Lugar?,
    onGoToMap: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomEnd = 30.dp, bottomStart = 0.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Column {
            Image(
                painter = painterResource(lugar?.imagen ?: 0),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(lugar?.descripcion ?: 0),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier
                    .padding(16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { onGoToMap() },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onTertiaryContainer
                )
                Text(
                    text = stringResource(lugar?.ubicacion ?: 0),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                )
            }
        }
    }
}

@Preview
@Composable
fun DetallesLugarPreview() {
    DetallesLugarScreen(
        lugar = DataSource.categorias[0].lugares[0],
        onGoToMap = {}
    )
}
