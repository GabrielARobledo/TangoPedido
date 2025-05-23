package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.component.card.SimpleCard
import com.axoft.tangopedido.presentation.common.layout.CustomHorizontalDivider
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.model.SimpleItemCard
import com.axoft.tangopedido.presentation.uistate.UiState

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    AppScaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {

            val clienteState by mainViewModel.clientes.collectAsState()
            val articuloState by mainViewModel.articulos.collectAsState()

            CargarState("Clientes", state = clienteState)
            CustomHorizontalDivider()
            CargarState("Artículos", state = articuloState)
        }
    }
}

@Composable
fun CargarState(labelState: String, state: UiState<List<SimpleItemCard>>) {
    Text(text = labelState, modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp))
    when (state) {
        is UiState.Loading -> Text("Cargando ${labelState}...")
        is UiState.Success -> {
            Column {
                state.data.forEach { item ->
                    SimpleCard(item = item)
                }
            }
        }

        is UiState.Error -> Text("Error: ${state.message}", color = MaterialTheme.colorScheme.error)
    }
}
