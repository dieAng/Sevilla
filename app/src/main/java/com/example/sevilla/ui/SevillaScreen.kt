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


enum class SevillaScreen(@StringRes val title: Int) {
    Categorias(title = R.string.app_name),
    Lugares(title = R.string.lugares),
    DetallesLugar(title = R.string.app_name)    // TODO("Colocar nombre correcto de la pantalla")
}

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

@Composable
fun SevillaApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = SevillaScreen.valueOf(
        backStackEntry?.destination?.route ?: SevillaScreen.Categorias.name
    )
    val viewModel: SevillaViewModel = viewModel()
    val context = LocalContext.current

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
                val lugar = uiState.currentLugar
                val ubicacion = stringResource(lugar?.ubicacion ?: 0)
                DetallesLugarScreen(
                    lugar = lugar,
                    onGoToMap = {
                        lugar?.let {
                            goToMap(context, ubicacion)
                        }
                    },
                    modifier = Modifier
                )
            }
        }
    }
}

@SuppressLint("QueryPermissionsNeeded")
private fun goToMap(context: Context, direccion: String) {
    val encodedAddress = Uri.encode(direccion)
    val locationUri = "geo:0,0?q=$encodedAddress".toUri()

    val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)
    mapIntent.setPackage("com.google.android.apps.maps")

    if (mapIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(mapIntent)
    }
}
