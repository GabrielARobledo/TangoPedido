package com.axoft.axmobilepedidos.presentation.feature.app.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation
import com.axoft.axmobilepedidos.presentation.feature.auth.ui.LoginScreen
import com.axoft.axmobilepedidos.presentation.feature.pedido.articulo.ui.ArticuloScreen
import com.axoft.axmobilepedidos.presentation.feature.pedido.cliente.ui.ClienteScreen
import com.axoft.axmobilepedidos.presentation.feature.pedido.pedido.add.PedidoNewScreen
import com.axoft.axmobilepedidos.presentation.feature.pedido.pedido.lookup.screen.PedidoScreen
import com.axoft.axmobilepedidos.presentation.feature.pedido.renglon.edit.RenglonEditScreen
import com.axoft.axmobilepedidos.presentation.feature.pedido.renglon.add.ui.RenglonScreen

/**
 * appNavGraph
 *
 * Extensión de NavGraphBuilder que define el gráfico principal de navegación
 * de la aplicación, registrando las rutas (composables) asociadas a cada pantalla clave.
 * Este gráfico organiza cómo el NavHostController puede moverse entre las diferentes
 * pantallas, usando las rutas definidas en AppNavigation.
 *
 * @param navController Controlador de navegación usado para gestionar el flujo entre pantallas.
 */
fun NavGraphBuilder.appNavGraph(
    navController: NavHostController
) {
    composable(AppNavigation.Login.route) {
        LoginScreen(navController)
    }
    composable(AppNavigation.Pedido.route) {
        PedidoScreen(navController)
    }
    composable(AppNavigation.NewPedido.route) {
        PedidoNewScreen(navController)
    }
    composable(AppNavigation.Cliente.route) {
        ClienteScreen(navController)
    }
    composable(AppNavigation.Articulo.route) {
        ArticuloScreen(navController)
    }
    composable(AppNavigation.Renglon.route) {
        RenglonScreen(navController)
    }
    composable(AppNavigation.ArticuloEdit.route) {
        RenglonEditScreen(navController)
    }
    composable(AppNavigation.Promociones.route) {
    }
}
