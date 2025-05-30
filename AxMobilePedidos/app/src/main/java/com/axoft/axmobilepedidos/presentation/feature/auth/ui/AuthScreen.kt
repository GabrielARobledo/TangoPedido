package com.axoft.axmobilepedidos.presentation.feature.auth.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.card.LoadItemCard
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.AppScaffold
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.ControlText
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ScreenLabels
import com.axoft.axmobilepedidos.presentation.feature.auth.viewmodel.AuthViewModel
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation

/**
 * LoginScreen
 *
 * Composable que representa la pantalla de login, mostrando un listado de vendedores
 * disponibles para autenticación. Permite al usuario seleccionar un vendedor,
 * disparando el proceso de login y navegando automáticamente a la pantalla principal (Home).
 *
 * @param navController Controlador de navegación para gestionar los cambios de pantalla.
 */
@Composable
fun LoginScreen(navController: NavHostController) {
    val authViewModel: AuthViewModel = hiltViewModel()
    val vendedorState by authViewModel.vendedores.collectAsState()

    AppScaffold {
        ControlText(ScreenLabels.Login)
        LoadItemCard(vendedorState) { itemSelected ->
            authViewModel.loginVendedor(itemSelected)
            navController.navigate(AppNavigation.Pedido.route) {
                popUpTo(AppNavigation.Login.route) {
                    inclusive = true
                }
            }
        }
    }
}
