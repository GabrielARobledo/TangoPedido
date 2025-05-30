package com.axoft.axmobilepedidos.presentation.feature.app.navigation

/**
 * AppNavigation
 *
 * Clase sellada que define las rutas de navegación principales de la aplicación,
 * asociando cada pantalla con una ruta única (string) que se usa para la navegación
 * interna mediante NavController.
 *
 * Provee objetos predefinidos para las pantallas clave: login, home, cliente,
 * artículo, edición de artículo, renglones y promociones.
 *
 * @param route Ruta de navegación única usada por el NavController.
 */
sealed class AppNavigation(val route: String) {
    object Login : AppNavigation("login")
    object Pedido : AppNavigation("pedido")
    object NewPedido : AppNavigation("newpedido")
    object Cliente : AppNavigation("cliente")
    object Articulo : AppNavigation("articulo")
    object ArticuloEdit : AppNavigation("articuloedit")
    object Renglon : AppNavigation("renglon")
    object Promociones : AppNavigation("promocion")
}
