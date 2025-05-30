package com.axoft.tangopedido.presentation.feature.articulo.articuloedit

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.feature.pedido.ui.pedidoViewModel

@Composable
fun ArticuloEditScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()

    LookupScaffold(navController, pedidoViewModel) {

    }
}
