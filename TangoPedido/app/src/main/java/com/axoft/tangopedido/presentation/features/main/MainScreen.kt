package com.axoft.tangopedido.presentation.features.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Tango Pedido") }) }
    ) { innerPadding ->
        Greeting(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
private fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Pedido mobile",
        modifier = modifier
    )
}
