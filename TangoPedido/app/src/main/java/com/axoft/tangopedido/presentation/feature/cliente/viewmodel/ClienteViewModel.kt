package com.axoft.tangopedido.presentation.feature.cliente.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.domain.model.ventas.Cliente
import com.axoft.tangopedido.domain.usecase.cliente.GetClientesUseCase
import com.axoft.tangopedido.presentation.common.utils.constant.ErrorConst
import com.axoft.tangopedido.presentation.common.utils.mapper.toSimpleItem
import com.axoft.tangopedido.presentation.common.utils.state.UiState
import com.axoft.tangopedido.presentation.model.view.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClienteViewModel @Inject constructor(
    private val getClientesUseCase: GetClientesUseCase
) :
    ViewModel() {

    private val _clientes =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Clientes"))
    val clientes: StateFlow<UiState<List<ItemCard>>> = _clientes.asStateFlow()

    init {
        setDataCliente()
    }

    fun setDataCliente() {
        viewModelScope.launch {
            try {
                val result: List<Cliente>? = getClientesUseCase()
                _clientes.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())

            } catch (ex: Exception) {
                _clientes.value = UiState.Error(message = "${ErrorConst.ERROR_MESSAGE} $ex")
            }
        }
    }
}