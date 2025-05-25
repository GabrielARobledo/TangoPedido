package com.axoft.tangopedido.presentation.feature.main

sealed class AppNavigation(val route: String) {
    object Login : AppNavigation("login")
    object Home : AppNavigation("home")
}
