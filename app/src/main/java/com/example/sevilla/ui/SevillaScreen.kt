package com.example.sevilla.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sevilla.R
import com.example.sevilla.ui.screens.CategoriaScreen
import com.example.sevilla.ui.screens.DetallesLugarScreen
import com.example.sevilla.ui.screens.LugaresScreen
import com.example.sevilla.ui.screens.SevillaViewModel
import androidx.core.net.toUri

/**
 * Un enum que representa las diferentes pantallas de la aplicación.
 *
 * @property title El ID del recurso de cadena para el título de la pantalla.
 */
enum class SevillaScreen(@StringRes val title: Int) {
    Categorias(title = R.string.app_name),
    Lugares(title = R.string.lugares),
    DetallesLugar(title = R.string.detalles_lugar)
}

/**
 * Una barra de aplicaciones superior componible para la aplicación de Sevilla.
 *
 * @param currentScreenTitle El ID del recurso de cadena para el título de la pantalla actual.
 * @param canNavigateBack Si el usuario puede navegar hacia atrás.
 * @param navigateUp La función a la que se llamará cuando el usuario haga clic en el icono de navegación.
 * @param modifier El modificador que se aplicará a la barra de aplicaciones superior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SevillaTopAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(currentScreenTitle),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        },
        modifier = modifier
    )
}

/**
 * El componible principal de la aplicación de Sevilla.
 */
@Composable
fun SevillaApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = SevillaScreen.valueOf(
        backStackEntry?.destination?.route ?: SevillaScreen.Categorias.name
    )
    val viewModel: SevillaViewModel = viewModel()

    Scaffold(
        topBar = {
            SevillaTopAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                    if (currentScreen == SevillaScreen.Lugares) viewModel.resetCurrentCategoria()
                    if (currentScreen == SevillaScreen.DetallesLugar) viewModel.resetCurrentLugar()
                }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = SevillaScreen.Categorias.name,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(route = SevillaScreen.Categorias.name) {
                CategoriaScreen(
                    categorias = uiState.categorias,
                    onCategoriaClick = { categoria ->
                        viewModel.updateCurrentCategoria(categoria)
                        navController.navigate(SevillaScreen.Lugares.name)
                    }
                )
            }

            composable(route = SevillaScreen.Lugares.name) {
                LugaresScreen(
                    lugares = uiState.currentCategoria?.lugares ?: emptyList(),
                    onLugarClick = { lugar ->
                        viewModel.updateCurrentLugar(lugar)
                        navController.navigate(SevillaScreen.DetallesLugar.name)
                    },
                    modifier = Modifier
                )
            }

            composable(route = SevillaScreen.DetallesLugar.name) {
                val context = LocalContext.current
                val lugar = uiState.currentLugar
                val direccion = if (lugar != null) stringResource(lugar.ubicacion) else null
                DetallesLugarScreen(
                    lugar = lugar,
                    onGoToMap = {
                        if (direccion != null) {
                            goToMap(context, direccion)
                        }
                    },
                    modifier = Modifier
                )
            }
        }
    }
}

/**
 * Navega a la aplicación de mapas con la dirección especificada.
 *
 * @param context El contexto de la aplicación.
 * @param direccion La dirección a mostrar en el mapa.
 */
@SuppressLint("QueryPermissionsNeeded")
private fun goToMap(context: Context, direccion: String) {
    val encodedAddress = Uri.encode(direccion)
    val locationUri = "geo:0,0?q=$encodedAddress".toUri()

    val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)

    if (mapIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(mapIntent)
    }
}

/**
 * Una vista previa componible para la aplicación de Sevilla.
 */
@Preview
@Composable
fun SevillaAppPreview() {
    SevillaApp()
}
