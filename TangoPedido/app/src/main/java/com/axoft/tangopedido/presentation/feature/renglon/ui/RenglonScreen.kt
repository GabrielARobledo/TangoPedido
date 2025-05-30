package com.axoft.tangopedido.presentation.feature.renglon.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.common.ui.component.card.RenglonCard
import com.axoft.tangopedido.presentation.common.ui.component.scaffold.LookupScaffold
import com.axoft.tangopedido.presentation.common.ui.component.text.ControlText
import com.axoft.tangopedido.presentation.feature.app.navigation.AppNavigation
import com.axoft.tangopedido.presentation.feature.pedido.ui.pedidoViewModel

@Composable
fun RenglonScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val pedido by pedidoViewModel.pedido.collectAsState()

    LookupScaffold(
        navController = navController,
        pedidoViewModel = pedidoViewModel,
        floatingActionButton = { RenglonFooter(navController) }) {

        ControlText("Renglones")
        pedido.articulos.forEach { renglon ->
            RenglonCard(renglonCard = renglon) {
                navController.navigate(AppNavigation.ArticuloEdit.route)
            }
        }
    }
}
