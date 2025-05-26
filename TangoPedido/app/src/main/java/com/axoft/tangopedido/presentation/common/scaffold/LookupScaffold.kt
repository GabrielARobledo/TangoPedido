package com.axoft.tangopedido.presentation.common.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.feature.pedido.PedidoViewModel

@Composable
fun LookupScaffold(
    navController: NavHostController,
    pedidoViewModel: PedidoViewModel,
    content: @Composable (PaddingValues) -> Unit
) {
    AppScaffold(
        isScrollable = true,
        topBar = {
            HomeToolbar(
                subtitle = pedidoViewModel.getNombreVendedorLogged(),
                arrowBack = true,
                backOnClick = {
                    navController.popBackStack()
                })
        },
    ) { innerPadding ->
        content.invoke(innerPadding)
    }
}
