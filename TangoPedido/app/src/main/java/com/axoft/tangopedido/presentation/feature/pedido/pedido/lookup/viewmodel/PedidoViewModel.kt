package com.axoft.tangopedido.presentation.feature.pedido.pedido.lookup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.domain.model.ventas.Pedido
import com.axoft.tangopedido.domain.usecase.pedido.GetPedidosUseCase
import com.axoft.tangopedido.presentation.common.utils.constant.ErrorConst
import com.axoft.tangopedido.presentation.common.utils.mapper.toPedidoUi
import com.axoft.tangopedido.presentation.common.utils.state.UiState
import com.axoft.tangopedido.presentation.model.view.PedidoUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

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