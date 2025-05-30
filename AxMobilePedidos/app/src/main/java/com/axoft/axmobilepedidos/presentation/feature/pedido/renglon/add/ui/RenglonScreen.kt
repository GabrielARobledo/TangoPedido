package com.axoft.axmobilepedidos.presentation.feature.pedido.renglon.add.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.card.RenglonCard
import com.axoft.axmobilepedidos.presentation.common.ui.component.floating.FloatingActionAdd
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.HomeScaffold
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.ControlText
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ScreenLabels
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation
import com.axoft.axmobilepedidos.presentation.shared.ui.pedidoViewModel

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

    HomeScaffold(
        navController = navController,
        pedidoViewModel = pedidoViewModel,
        floatingActionButton = { FloatingActionAdd(navController, AppNavigation.Articulo) }
    ) {
        if (pedido.renglones.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Sin artículos",
                    modifier = Modifier.size(64.dp),
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No hay renglones cargados aún.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
        } else {
            ControlText(ScreenLabels.Articulo)
            LazyColumn {
                items(pedido.renglones) { renglon ->
                    RenglonCard(renglonUi = renglon) {
                        navController.navigate(AppNavigation.ArticuloEdit.route)
                    }
                }
            }
        }
    }
}
