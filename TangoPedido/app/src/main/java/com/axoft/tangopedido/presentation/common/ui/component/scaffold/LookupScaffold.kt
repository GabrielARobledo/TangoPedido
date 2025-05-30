package com.axoft.tangopedido.presentation.common.ui.component.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.feature.pedido.viewmodel.PedidoViewModel

@Composable
fun LookupScaffold(
    navController: NavHostController,
    pedidoViewModel: PedidoViewModel,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    AppScaffold(
        isScrollable = true,
        floatingActionButton = floatingActionButton,
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
