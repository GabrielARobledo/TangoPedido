package com.axoft.tangopedido.presentation.feature.app.navigation

sealed class AppNavigation(val route: String, val label: String) {
    object Login : AppNavigation("login", "Vendedor")
    object Home : AppNavigation("home", "")
    object Cliente : AppNavigation("cliente", "Cliente")
    object Articulo : AppNavigation("articulo", "Artículo")
    object ArticuloEdit : AppNavigation("articuloedit", "Edición artículo")
    object Renglon : AppNavigation("renglon", "Renglones")
    object Promociones : AppNavigation("promocion", "Promoción")
}