package com.axoft.axmobilepedidos.presentation.feature.pedido.pedido.lookup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.axmobilepedidos.domain.model.ventas.Pedido
import com.axoft.axmobilepedidos.domain.usecase.pedido.GetPedidosUseCase
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ErrorConst
import com.axoft.axmobilepedidos.presentation.common.utils.mapper.toPedidoUi
import com.axoft.axmobilepedidos.presentation.common.utils.state.UiState
import com.axoft.axmobilepedidos.presentation.model.view.PedidoUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel encargado de gestionar el estado de la lista de pedidos.
 *
 * Usa un StateFlow expuesto como UiState<List<PedidoUi>> para representar:
 * - Loading: cuando se está cargando la información.
 * - Success: cuando se cargaron correctamente los pedidos.
 * - Error: cuando ocurre un fallo al obtener los pedidos.
 *
 * Obtiene los datos usando el caso de uso [GetPedidosUseCase] y los mapea a [PedidoUi]
 * usando el mapper toPedidoUi().
 *
 * @property getPedidosUseCase Caso de uso inyectado para obtener la lista de pedidos.
 */
@HiltViewModel
class PedidoViewModel @Inject constructor(private val getPedidosUseCase: GetPedidosUseCase) :
    ViewModel() {

    private val _pedidos =
        MutableStateFlow<UiState<List<PedidoUi>>>(UiState.Loading("Pedidos"))
    val pedidos: StateFlow<UiState<List<PedidoUi>>> = _pedidos.asStateFlow()

    init {
        setDataArticulo()
    }

    fun setDataArticulo() {
        viewModelScope.launch {
            try {
                val result: List<Pedido> = getPedidosUseCase()
                _pedidos.value = UiState.Success(result.map { it.toPedidoUi() })

            } catch (ex: Exception) {
                _pedidos.value = UiState.Error(message = "${ErrorConst.ERROR_MESSAGE} $ex")
            }
        }
    }
}