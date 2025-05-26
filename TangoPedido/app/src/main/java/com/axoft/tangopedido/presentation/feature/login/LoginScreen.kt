package com.axoft.tangopedido.presentation.feature.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.component.card.LoadItemCard
import com.axoft.tangopedido.presentation.common.component.text.ControlText
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.feature.main.AppNavigation

@Composable
fun LoginScreen(navController: NavHostController) {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val vendedorState by loginViewModel.vendedores.collectAsState()

    AppScaffold {
        ControlText(AppNavigation.Login.label)
        LoadItemCard(vendedorState) { itemSelected ->
            loginViewModel.loginVendedor(itemSelected)
            navController.navigate(AppNavigation.Home.route) {
                popUpTo(AppNavigation.Login.route) {
                    inclusive = true
                }
            }
        }
    }
}
