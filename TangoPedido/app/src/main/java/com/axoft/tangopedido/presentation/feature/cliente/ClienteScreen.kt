package com.axoft.tangopedido.presentation.feature.cliente

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import com.axoft.tangopedido.presentation.common.component.card.LoadItemCard
import com.axoft.tangopedido.presentation.common.component.text.ControlText
import com.axoft.tangopedido.presentation.common.component.textfield.CustomTextField
import com.axoft.tangopedido.presentation.common.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.feature.pedido.pedidoViewModel

@Composable
fun ClienteScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val clienteViewModel: ClienteViewModel = hiltViewModel()
    val clienteState by clienteViewModel.clientes.collectAsState()

    LookupScaffold(navController, pedidoViewModel) {
        var searchText by remember { mutableStateOf("") }

        ControlText("Cliente")
        CustomTextField(label = "Buscar", value = searchText) { searchText = it }
        Spacer(modifier = Modifier.height(8.dp))
        LoadItemCard(clienteState) { itemSelected ->
            pedidoViewModel.setCliente(itemSelected)
            navController.popBackStack()
        }
    }
}
