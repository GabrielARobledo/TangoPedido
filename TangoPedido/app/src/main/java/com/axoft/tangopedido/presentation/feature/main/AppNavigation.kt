package com.axoft.tangopedido.presentation.feature.main

sealed class AppNavigation(val route: String, val label: String) {
    object Login : AppNavigation("login", "Vendedor")
    object Home : AppNavigation("home", "")
    object Cliente : AppNavigation("cliente", "Cliente")
    object Articulo : AppNavigation("articulo", "Artículo")
    object Promociones : AppNavigation("promocion", "Promoción")
}
