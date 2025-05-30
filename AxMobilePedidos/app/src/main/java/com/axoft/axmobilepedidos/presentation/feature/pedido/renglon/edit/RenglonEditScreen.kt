package com.axoft.axmobilepedidos.presentation.feature.pedido.renglon.edit

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.HomeScaffold
import com.axoft.axmobilepedidos.presentation.shared.ui.pedidoViewModel

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
fun RenglonEditScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()

    HomeScaffold(navController, pedidoViewModel) {

    }
}
