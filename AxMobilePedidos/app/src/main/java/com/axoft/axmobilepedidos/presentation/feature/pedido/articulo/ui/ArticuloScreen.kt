package com.axoft.axmobilepedidos.presentation.feature.pedido.articulo.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.axoft.axmobilepedidos.presentation.common.ui.component.card.LoadItemCard
import com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold.HomeScaffold
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.ControlText
import com.axoft.axmobilepedidos.presentation.common.ui.component.textfield.CustomTextField
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ScreenLabels
import com.axoft.axmobilepedidos.presentation.feature.pedido.articulo.viewmodel.ArticuloViewModel
import com.axoft.axmobilepedidos.presentation.shared.ui.pedidoViewModel

/**
 * ArticuloScreen
 *
 * Composable que representa la pantalla de selección de artículo dentro del flujo de pedido.
 * Permite buscar y seleccionar un artículo, mostrando un listado filtrable,
 * y al seleccionar uno, lo agrega al PedidoViewModel global y regresa a la pantalla anterior.
 *
 * @param navController Controlador de navegación usado para gestionar las rutas.
 */
@Composable
fun ArticuloScreen(navController: NavHostController) {
    val pedidoViewModel = pedidoViewModel()
    val articuloViewModel: ArticuloViewModel = hiltViewModel()
    val articuloState by articuloViewModel.articulos.collectAsState()

    var searchText by remember { mutableStateOf("") }

    HomeScaffold(navController, pedidoViewModel) {
        ControlText(ScreenLabels.Articulo)
        CustomTextField(label = "Buscar", value = searchText) { searchText = it }
        Spacer(modifier = Modifier.height(8.dp))

        LoadItemCard(
            state = articuloState,
            imageIcon = Icons.Default.FavoriteBorder
        ) { itemSelected ->
            pedidoViewModel.addArticulo(itemSelected)
            navController.popBackStack()
        }
    }
}
