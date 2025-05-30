package com.axoft.axmobilepedidos.presentation.feature.pedido.cliente.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.axmobilepedidos.domain.model.ventas.Cliente
import com.axoft.axmobilepedidos.domain.usecase.cliente.GetClientesUseCase
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ErrorConst
import com.axoft.axmobilepedidos.presentation.common.utils.mapper.toSimpleItem
import com.axoft.axmobilepedidos.presentation.common.utils.state.UiState
import com.axoft.axmobilepedidos.presentation.model.view.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ClienteViewModel
 *
 * ViewModel encargado de gestionar la lógica y el estado de la pantalla de selección
 * de clientes. Recupera los clientes desde el dominio usando GetClientesUseCase,
 * transforma los datos a objetos ItemCard para la UI, y expone el estado
 * mediante UiState (Loading, Success, Error) para ser consumido por los composables.
 *
 * @param getClientesUseCase UseCase que obtiene la lista de clientes desde el dominio.
 */
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