package com.axoft.tangopedido.presentation.feature.pedido.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.axoft.tangopedido.presentation.feature.pedido.viewmodel.PedidoViewModel
import com.axoft.tangopedido.presentation.feature.pedido.helper.findActivity

@Composable
fun pedidoViewModel(): PedidoViewModel {
    val context = LocalContext.current
    val activity = context.findActivity()
    return hiltViewModel(activity)
}
