package com.axoft.tangopedido.presentation.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.component.card.SimpleCard
import com.axoft.tangopedido.presentation.common.component.progress.CircularProgressCustom
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.feature.main.AppNavigation
import com.axoft.tangopedido.presentation.uistate.UiState

@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavHostController) {
    AppScaffold {
        val vendedorState by loginViewModel.vendedores.collectAsState()
        val currentState = vendedorState

        Text("Vendedor")

        when (currentState) {
            is UiState.Loading -> CircularProgressCustom(currentState.label)
            is UiState.Success -> {
                Column {
                    currentState.data.forEach { item ->
                        SimpleCard(item = item) { itemSelected ->
                            loginViewModel.loginVendedor(itemSelected.id)
                            navController.navigate(AppNavigation.Home.route) {
                                popUpTo(AppNavigation.Login.route) {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
            }

            is UiState.Error -> Text(
                "Error: ${currentState.message}",
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}