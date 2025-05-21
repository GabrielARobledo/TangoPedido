package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.feature.home.HomeScreen
import com.axoft.tangopedido.presentation.feature.login.LoginScreen

@Composable
fun MainScreen(mainViewModel: MainViewModel, clienteViewModel: ClienteViewModel, paisViewModel: PaisViewModel) {
    val isLogged by mainViewModel.isLogged.collectAsState()
    val clienteData by clienteViewModel.data.observeAsState()
    val paisData by paisViewModel.data.observeAsState()

    //LaunchedEffect(Unit) {
    //    clienteViewModel.fetchData()
    //}

    LaunchedEffect(Unit) {
        paisViewModel.getData()
    }

    AppScaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

            // Mostrar los datos si están disponibles
            //clienteData?.let { data ->
            //    Text("Cliente: ${data.value.COD_GVA14 ?: "Sin nombre"}") // o lo que quieras mostrar
            //} ?: run {
            //    Text("Cargando datos del cliente...")
            //}

            paisData?.let { data ->
                Text("Pais: ${data.value.NOM_PAIS ?: "Sin nombre"}") // o lo que quieras mostrar
            } ?: run {
                Text("Cargando datos del pais...")
            }

            //if (isLogged) {
            //    HomeScreen()
            //} else {
            //    LoginScreen(mainViewModel)
            //}
        }
    }
}
