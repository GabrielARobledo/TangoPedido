package com.axoft.tangopedido.presentation.feature.pedido.renglon.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.card.RenglonCard
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.common.ui.component.text.ControlText
import com.axoft.tangopedido.presentation.feature.core.app.navigation.AppNavigation
import com.axoft.tangopedido.presentation.shared.ui.pedidoViewModel

/**
 * RenglonScreen
 *
 * Composable que representa la pantalla de listado de renglones del pedido.
 * Muestra los artículos ya seleccionados usando RenglonCard y permite navegar
 * a la pantalla de edición de artículo al hacer clic en cada uno.
 * Usa LookupScaffold para mantener una estructura consistente con topBar y FAB,
 * integrando además el PedidoViewModel global para obtener los datos del pedido actual.
 *
 * @param navController Controlador de navegación para gestionar los cambios de pantalla.
 */
@Composable
fun RenglonScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val pedido by pedidoViewModel.pedido.collectAsState()

    LookupScaffold(
        navController = navController,
        pedidoViewModel = pedidoViewModel,
        floatingActionButton = { RenglonFooter(navController) }) {

        ControlText("Renglones")
        pedido.articulos.forEach { renglon ->
            RenglonCard(renglonCard = renglon) {
                navController.navigate(AppNavigation.ArticuloEdit.route)
            }
        }
    }
}
