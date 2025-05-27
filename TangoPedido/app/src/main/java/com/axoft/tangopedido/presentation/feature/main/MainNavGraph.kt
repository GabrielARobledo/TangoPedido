package com.axoft.tangopedido.presentation.feature.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.axoft.tangopedido.presentation.feature.articulo.ArticuloScreen
import com.axoft.tangopedido.presentation.feature.articulo.articuloedit.ArticuloEditScreen
import com.axoft.tangopedido.presentation.feature.cliente.ClienteScreen
import com.axoft.tangopedido.presentation.feature.home.HomeScreen
import com.axoft.tangopedido.presentation.feature.login.LoginScreen
import com.axoft.tangopedido.presentation.feature.lookup.LookupScreen
import com.axoft.tangopedido.presentation.feature.renglon.RenglonScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {
    composable(AppNavigation.Login.route) {
        LoginScreen(navController)
    }
    composable(AppNavigation.Home.route) {
        HomeScreen(navController)
    }
    composable(AppNavigation.Cliente.route) {
        ClienteScreen(navController)
    }
    composable(AppNavigation.Renglon.route) {
        RenglonScreen(navController)
    }
    composable(AppNavigation.Articulo.route) {
        ArticuloScreen(navController)
    }
    composable(AppNavigation.ArticuloEdit.route) {
        ArticuloEditScreen(navController)
    }
    composable(AppNavigation.Promociones.route) {
        LookupScreen(navController)
    }
}
