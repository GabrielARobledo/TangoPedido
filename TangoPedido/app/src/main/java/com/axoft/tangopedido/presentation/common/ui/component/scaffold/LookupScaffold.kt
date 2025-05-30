package com.axoft.tangopedido.presentation.common.ui.component.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.shared.viewmodel.PedidoViewModel

/**
 * LookupScaffold
 *
 * Composable especializado que envuelve la estructura base de pantallas tipo “lookup”
 * (selección/listado) usando AppScaffold. Integra una HomeToolbar con subtítulo dinámico
 * (nombre del vendedor) y back button, permitiendo inyectar contenido flexible y opcional
 * FloatingActionButton.
 *
 * @param navController Controlador de navegación usado para manejar el back stack.
 * @param pedidoViewModel ViewModel global que provee información del pedido actual.
 * @param floatingActionButton Composable opcional para incluir un FAB en la pantalla.
 * @param content Bloque composable que representa el contenido principal de la pantalla,
 * recibiendo los PaddingValues del scaffold.
 */
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
                backOnClick = { navController.popBackStack() })
        },
    ) { innerPadding ->
        content.invoke(innerPadding)
    }
}
