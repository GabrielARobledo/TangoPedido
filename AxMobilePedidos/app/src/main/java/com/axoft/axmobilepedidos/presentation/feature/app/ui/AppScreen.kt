package com.axoft.axmobilepedidos.presentation.feature.app.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.axoft.axmobilepedidos.presentation.common.ui.component.animation.SlideNavHost
import com.axoft.axmobilepedidos.presentation.feature.app.viewmodel.AppViewModel

/**
 * AppScreen
 *
 * Composable principal de la aplicación que inicializa el ViewModel global (AppViewModel),
 * configura el controlador de navegación (NavHostController), y monta el SlideNavHost
 * con el gráfico de navegación principal (appNavGraph).
 *
 * Este componente es el punto de entrada de la UI y determina cuál será la pantalla
 * inicial usando el metodo getStartRoute() del AppViewModel.
 *
 * @see AppViewModel
 * @see SlideNavHost
 * @see appNavGraph
 */
@Composable
fun AppScreen() {
    val appViewModel: AppViewModel = hiltViewModel()
    val navController = rememberNavController()

    SlideNavHost(
        navController = navController,
        startDestination = appViewModel.getStartRoute()
    ) {
        appNavGraph(navController)
    }
}
