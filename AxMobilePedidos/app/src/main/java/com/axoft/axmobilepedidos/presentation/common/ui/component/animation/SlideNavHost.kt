package com.axoft.axmobilepedidos.presentation.common.ui.component.animation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

const val SLIDE_ANIMATION_DURATION_MS = 300

/**
 * SlideNavHost
 *
 * Composable que envuelve el NavHost de Jetpack Compose añadiendo transiciones
 * de entrada y salida animadas de tipo slide horizontal.
 * Define las animaciones para navegar entre pantallas (enter, exit, popEnter, popExit),
 * usando una duración configurable por constante.
 *
 * @param modifier Modificador Compose opcional para personalizar el layout externo.
 * @param navController Controlador de navegación para gestionar el stack de pantallas.
 * @param startDestination Ruta inicial de la navegación.
 * @param builder Bloque de construcción que define el gráfico de navegación.
 */
@Composable
fun SlideNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    builder: NavGraphBuilder.() -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(SLIDE_ANIMATION_DURATION_MS)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(SLIDE_ANIMATION_DURATION_MS)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(SLIDE_ANIMATION_DURATION_MS)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(SLIDE_ANIMATION_DURATION_MS)
            )
        }) {
        builder()
    }
}
