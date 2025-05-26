package com.axoft.tangopedido.presentation.feature.pedido

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun pedidoViewModel(): PedidoViewModel {
    val context = LocalContext.current
    val activity = context.findActivity()
    return hiltViewModel(activity)
}
