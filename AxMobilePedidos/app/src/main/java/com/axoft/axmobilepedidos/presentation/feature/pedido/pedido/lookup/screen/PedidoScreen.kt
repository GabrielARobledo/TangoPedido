package com.axoft.axmobilepedidos.presentation.feature.pedido.pedido.lookup.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.card.PedidoCard
import com.axoft.axmobilepedidos.presentation.common.ui.component.floating.FloatingActionAdd
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.HomeScaffold
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.ControlText
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ScreenLabels
import com.axoft.axmobilepedidos.presentation.common.utils.state.UiState
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation
import com.axoft.axmobilepedidos.presentation.feature.pedido.pedido.lookup.viewmodel.PedidoViewModel
import com.axoft.axmobilepedidos.presentation.model.view.PedidoUi
import com.axoft.axmobilepedidos.presentation.shared.ui.pedidoViewModel

/**
 * Pantalla principal que muestra la lista de pedidos existentes.
 *
 * Esta pantalla gestiona tres estados visuales:
 * - Cargando (Loading): Muestra un indicador circular de progreso.
 * - Éxito (Success): Muestra una lista (LazyColumn) de pedidos usando PedidoCard.
 * - Error (Error): Muestra un ícono y mensaje de error.
 *
 * Además, incluye:
 * - Un botón flotante (FloatingActionAdd) para crear un nuevo pedido.
 * - Un topbar controlado por HomeScaffold.
 *
 * @param navController Controlador de navegación para gestionar cambios de pantalla.
 */
@Composable
fun PedidoScreen(navController: NavHostController) {
    val pedidoAppViewModel = pedidoViewModel()

    val pedidoViewModel: PedidoViewModel = hiltViewModel()
    val pedidosState by pedidoViewModel.pedidos.collectAsState()

    HomeScaffold(
        navController = navController,
        pedidoViewModel = pedidoAppViewModel,
        arrowBack = false,
        floatingActionButton = { FloatingActionAdd(navController, AppNavigation.NewPedido) }
    ) {
        ControlText(ScreenLabels.Pedido)
        when (pedidosState) {
            is UiState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = (pedidosState as UiState.Loading).label,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

            is UiState.Success -> {
                val pedidos = (pedidosState as UiState.Success<List<PedidoUi>>).data
                LazyColumn {
                    items(pedidos) { pedido ->
                        PedidoCard(pedidoUi = pedido) {
                            //navController.navigate(AppNavigation.PedidoDetail.route)
                        }
                    }
                }
            }

            is UiState.Error -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        modifier = Modifier.size(64.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = (pedidosState as UiState.Error).message,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Red
                    )
                }
            }
        }
    }
}
