package com.axoft.tangopedido.presentation.common.toolbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar() {
    TopAppBar(title = { Text("Tango Pedido") })
}