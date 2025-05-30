package com.axoft.axmobilepedidos.presentation.shared.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.axoft.axmobilepedidos.presentation.shared.viewmodel.PedidoViewModel
import com.axoft.axmobilepedidos.presentation.shared.helper.findActivity

/**
 * pedidoViewModel
 *
 * Composable helper que permite obtener el PedidoViewModel global
 * asociado a la actividad actual, usando Hilt para la inyección de dependencias.
 *
 * Busca la actividad a partir del contexto local (LocalContext)
 * mediante la función findActivity, y luego recupera el ViewModel
 * con hiltViewModel, garantizando que se comparta entre múltiples composables
 * dentro de la misma actividad.
 *
 * @return Instancia compartida de PedidoViewModel.
 */
@Composable
fun pedidoViewModel(): PedidoViewModel {
    val context = LocalContext.current
    val activity = context.findActivity()
    return hiltViewModel(activity)
}
