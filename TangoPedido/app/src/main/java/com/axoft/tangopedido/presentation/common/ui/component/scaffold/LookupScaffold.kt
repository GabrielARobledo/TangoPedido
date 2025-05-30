package com.axoft.tangopedido.presentation.common.ui.component.scaffold

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.shared.viewmodel.PedidoViewModel

/**
 * LookupScaffold
 *
 * Composable que envuelve AppScaffold usando una estructura común para pantallas de pedidos.
 * - Muestra un HomeToolbar con el nombre del vendedor y botón de volver.
 * - Permite agregar un FloatingActionButton opcional.
 * - Recibe el contenido principal (content) que se muestra en la pantalla.
 *
 * Sirve para evitar repetir la misma estructura en cada pantalla relacionada a pedidos.
 */
@Composable
fun LookupScaffold(
    navController: NavHostController,
    pedidoViewModel: PedidoViewModel,
    arrowBack: Boolean = true,
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    AppScaffold(
        floatingActionButton = floatingActionButton,
        topBar = {
            HomeToolbar(
                subtitle = pedidoViewModel.getNombreVendedorLogged(),
                arrowBack = arrowBack,
                backOnClick = { navController.popBackStack() })
        },
        content = { content() }
    )
}
