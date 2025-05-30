package com.axoft.axmobilepedidos.presentation.feature.pedido.cliente.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.card.LoadItemCard
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.HomeScaffold
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.ControlText
import com.axoft.axmobilepedidos.presentation.common.ui.component.textfield.CustomTextField
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ScreenLabels
import com.axoft.axmobilepedidos.presentation.feature.pedido.cliente.viewmodel.ClienteViewModel
import com.axoft.axmobilepedidos.presentation.shared.ui.pedidoViewModel

/**
 * ClienteScreen
 *
 * Composable que representa la pantalla de selección de cliente dentro del flujo de pedido.
 * Permite buscar y seleccionar un cliente, mostrando un listado filtrable,
 * y al seleccionar uno, lo guarda en el PedidoViewModel global y regresa a la pantalla anterior.
 *
 * @param navController Controlador de navegación usado para gestionar las rutas.
 */
@Composable
fun ClienteScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val clienteViewModel: ClienteViewModel = hiltViewModel()
    val clienteState by clienteViewModel.clientes.collectAsState()

    HomeScaffold(navController, pedidoViewModel) {
        var searchText by remember { mutableStateOf("") }

        ControlText(ScreenLabels.Cliente)
        CustomTextField(label = "Buscar", value = searchText) { searchText = it }
        Spacer(modifier = Modifier.height(8.dp))
        LoadItemCard(state = clienteState, imageIcon = Icons.Default.Person) { itemSelected ->
            pedidoViewModel.setCliente(itemSelected)
            navController.popBackStack()
        }
    }
}
