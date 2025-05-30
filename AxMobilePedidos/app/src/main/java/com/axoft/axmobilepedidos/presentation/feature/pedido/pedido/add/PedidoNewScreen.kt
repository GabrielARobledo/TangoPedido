package com.axoft.axmobilepedidos.presentation.feature.pedido.pedido.add

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.card.SelectCard
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.HomeScaffold
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ScreenLabels
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation
import com.axoft.axmobilepedidos.presentation.shared.ui.pedidoViewModel

/**
 * Pantalla principal para crear un nuevo pedido.
 *
 * Esta pantalla permite al usuario seleccionar:
 * - El cliente para el pedido
 * - Los renglones (ítems) a incluir
 * - Las promociones aplicables
 *
 * Usa HomeScaffold para estructurar la vista general y
 * SelectCard para cada uno de los pasos principales.
 *
 * @param navController Controlador de navegación para manejar los flujos entre pantallas.
 */
@Composable
fun PedidoNewScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val pedido by pedidoViewModel.pedido.collectAsState()

    HomeScaffold(
        navController = navController,
        pedidoViewModel = pedidoViewModel, toolbarRightContent = { Text("$0.00") }
    ) {
        SelectCard(
            label = ScreenLabels.Cliente,
            value = "Seleccionar cliente",
            valueSelected = pedido.clienteSelected?.getCodeDescription()
        ) {
            navController.navigate(AppNavigation.Cliente.route)
        }
        Spacer(modifier = Modifier.height(10.dp))
        SelectCard(
            label = ScreenLabels.Renglon, value = "Ingresar renglones"
        ) {
            navController.navigate(AppNavigation.Renglon.route)
        }
        Spacer(modifier = Modifier.height(10.dp))
        SelectCard(
            label = ScreenLabels.Promociones, value = "Seleccionar cliente"
        ) {
            navController.navigate(AppNavigation.Promociones.route)
        }
    }
}
