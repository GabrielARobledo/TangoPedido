package com.axoft.tangopedido.presentation.feature.pedido.articulo.edit

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.shared.ui.pedidoViewModel

/**
 * ArticuloEditScreen
 *
 * Composable que representa la pantalla de edición de artículo dentro del flujo de pedido.
 * Usa LookupScaffold para mantener la estructura consistente (con topBar y paddings)
 * y accede al PedidoViewModel global para interactuar con los datos del pedido actual.
 *
 * Actualmente no contiene contenido interno (solo prepara la estructura base).
 *
 * @param navController Controlador de navegación para gestionar los cambios de pantalla.
 */
@Composable
fun ArticuloEditScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()

    LookupScaffold(navController, pedidoViewModel) {

    }
}
