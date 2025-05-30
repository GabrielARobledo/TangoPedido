package com.axoft.tangopedido.presentation.feature.lookup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.feature.pedido.ui.pedidoViewModel

@Composable
fun LookupScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    LookupScaffold(navController, pedidoViewModel) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
        }
    }
}
