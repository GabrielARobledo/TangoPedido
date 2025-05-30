package com.axoft.tangopedido.presentation.feature.pedido.pedido.add

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.card.SelectCard
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.common.ui.component.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.common.utils.constant.ScreenLabels
import com.axoft.tangopedido.presentation.feature.core.app.navigation.AppNavigation
import com.axoft.tangopedido.presentation.shared.ui.pedidoViewModel

@Composable
fun PedidoNewScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val pedido by pedidoViewModel.pedido.collectAsState()

    AppScaffold(
        topBar = { HomeToolbar(pedidoViewModel.getNombreVendedorLogged()) }) {
        SelectCard(
            label = ScreenLabels.Cliente,
            value = "Seleccionar cliente",
            valueSelected = pedido.clienteSelected?.getCodeDescription()
        ) {
            navController.navigate(AppNavigation.Cliente.route)
        }

        SelectCard(
            label = ScreenLabels.Renglon, value = "Ingresar renglones"
        ) {
            navController.navigate(AppNavigation.Renglon.route)
        }

        SelectCard(
            label = ScreenLabels.Promociones, value = "Seleccionar cliente"
        ) {
            navController.navigate(AppNavigation.Promociones.route)
        }
    }
}
