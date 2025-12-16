package com.example.sevilla

import android.content.Context
import android.content.Intent
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
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sevilla.ui.CategoriaScreen
import com.example.sevilla.ui.DetallesLugarScreen
import com.example.sevilla.ui.LugaresScreen
import com.example.sevilla.ui.SevillaViewModel


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
        modifier = modifier,
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
                DetallesLugarScreen(
                    lugar = uiState.currentLugar,
                    modifier = Modifier
                )
            }
        }
    }
}

private fun NavigateToCategorias(
    viewModel: SevillaViewModel,
    navController: NavHostController
) {
    viewModel.resetCurrentLugar()
    viewModel.resetCurrentCategoria()
    navController.popBackStack(SevillaScreen.Categorias.name, inclusive = false)
}

private fun GoToMap(
    context: Context,
    subject: String,
    summary: String
) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.app_name)  // TODO("Colocar titulo correcto")
        )
    )
}
