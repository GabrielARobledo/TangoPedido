package com.axoft.tangopedido.presentation.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.component.card.SimpleCard
import com.axoft.tangopedido.presentation.common.component.progress.CircularProgressCustom
import com.axoft.tangopedido.presentation.common.layout.CustomHorizontalDivider
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.common.toolbar.HomeToolbar
import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.uistate.UiState

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val pedido by homeViewModel.pedido.collectAsState()

    AppScaffold(isScrollable = true, topBar = { HomeToolbar(pedido.vendedorLogged?.nombre) }) {
        val clienteState by homeViewModel.clientes.collectAsState()
        val articuloState by homeViewModel.articulos.collectAsState()

        CargarState(pedido.clienteSeleccionado, clienteState) { itemSelected ->
            homeViewModel.seleccionarCliente(itemSelected)
        }
        CustomHorizontalDivider()
        CargarState(pedido.articuloSeleccionado, articuloState) { itemSelected ->
            homeViewModel.seleccionarArticulo(itemSelected)
        }
    }
}

@Composable
fun CargarState(
    itemSelected: ItemCard?,
    state: UiState<List<ItemCard>>,
    onClick: (ItemCard) -> Unit
) = if (itemSelected != null) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = itemSelected.icon, contentDescription = "Información: ")
        Text(
            text = itemSelected.getCodeDescription(),
            modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
} else {
    when (state) {
        is UiState.Loading -> CircularProgressCustom(state.label)
        is UiState.Success -> {
            Column {
                state.data.forEach { item ->
                    SimpleCard(item = item) { itemSelected ->
                        onClick(itemSelected)
                    }
                }
            }
        }

        is UiState.Error -> Text(
            "Error: ${state.message}",
            color = MaterialTheme.colorScheme.error
        )
    }
}
