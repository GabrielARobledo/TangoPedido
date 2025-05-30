package com.axoft.tangopedido.presentation.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.card.SelectCard
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.common.ui.component.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.feature.app.navigation.AppNavigation
import com.axoft.tangopedido.presentation.feature.pedido.ui.pedidoViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val pedido by pedidoViewModel.pedido.collectAsState()

    AppScaffold(
        isScrollable = true,
        topBar = { HomeToolbar(pedidoViewModel.getNombreVendedorLogged()) }) {
        SelectCard(
            label = AppNavigation.Cliente.label,
            value = "Seleccionar cliente",
            valueSelected = pedido.clienteSelected?.getCodeDescription()
        ) {
            navController.navigate(AppNavigation.Cliente.route)
        }

        SelectCard(
            (AppNavigation.Renglon.label),
            value = "Ingresar renglones"
        ) {
            navController.navigate(AppNavigation.Renglon.route)
        }

        SelectCard(
            label = AppNavigation.Promociones.label,
            value = "Seleccionar cliente"
        ) {
            navController.navigate(AppNavigation.Promociones.route)
        }
    }
}
