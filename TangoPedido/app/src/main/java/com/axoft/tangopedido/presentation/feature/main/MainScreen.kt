package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val paisData by mainViewModel.data.observeAsState()
    val articuloList by mainViewModel.articulo.observeAsState()

    AppScaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).verticalScroll(rememberScrollState())) {

            paisData?.let { data ->
                Text("Pais: ${data.nomPais ?: "Sin nombre"}") // o lo que quieras mostrar
            } ?: run {
                Text("Cargando datos del pais...")
            }
            Spacer(modifier = Modifier.height(20.dp))

            articuloList?.let { data ->
                data.forEach { articulo ->
                    Column {
                        Text("Codigo: ${articulo.codigo}") // o lo que quieras mostrar
                        Text("Descripción: ${articulo.descripcion}") // o lo que quieras mostrar
                        HorizontalDivider(color = Color.Gray)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            } ?: run {
                Text("Cargando datos del pais...")
            }
        }
    }
}
