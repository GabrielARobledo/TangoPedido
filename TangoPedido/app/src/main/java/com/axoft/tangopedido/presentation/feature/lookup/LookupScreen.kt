package com.axoft.tangopedido.presentation.feature.lookup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.feature.pedido.pedidoViewModel

@Composable
fun LookupScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    LookupScaffold(navController, pedidoViewModel) {
        var searchText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
        }
    }
}
