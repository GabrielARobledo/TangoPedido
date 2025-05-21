package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val isLogged by mainViewModel.isLogged.collectAsState()
    val paisData by mainViewModel.data.observeAsState()

    AppScaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            paisData?.let { data ->
                Text("Pais: ${data.value.NOM_PAIS ?: "Sin nombre"}") // o lo que quieras mostrar
            } ?: run {
                Text("Cargando datos del pais...")
            }
        }
    }
}
