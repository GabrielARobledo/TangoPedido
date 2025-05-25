package com.axoft.tangopedido.presentation.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.repository.VendedorSessionRepository
import com.axoft.tangopedido.domain.model.Articulo
import com.axoft.tangopedido.domain.model.Cliente
import com.axoft.tangopedido.domain.usecase.articulo.GetArticulosUseCase
import com.axoft.tangopedido.domain.usecase.cliente.GetClientesUseCase
import com.axoft.tangopedido.presentation.constant.ErrorConst.ERROR_MESSAGE
import com.axoft.tangopedido.presentation.mapper.toSimpleItem
import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.model.Pedido
import com.axoft.tangopedido.presentation.uistate.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getClientesUseCase: GetClientesUseCase,
    private val getArticuloUseCase: GetArticulosUseCase,
    private val vendedorSessionRepository: VendedorSessionRepository
) : ViewModel() {

    private val _pedido = MutableStateFlow<Pedido>(Pedido())
    val pedido: StateFlow<Pedido> = _pedido.asStateFlow()

    private val _clientes =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Clientes"))
    val clientes: StateFlow<UiState<List<ItemCard>>> = _clientes.asStateFlow()

    private val _articulos =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Articulos"))
    val articulos: StateFlow<UiState<List<ItemCard>>> = _articulos.asStateFlow()

    init {
        _pedido.value = _pedido.value.copy(vendedorLogged = vendedorSessionRepository.getVendedor())
        setDataCliente()
        setDataArticulo()
    }

    fun setDataCliente() {
        viewModelScope.launch {
            try {
                val result: List<Cliente>? = getClientesUseCase()
                _clientes.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())

            } catch (ex: kotlin.Exception) {
                _clientes.value = UiState.Error(message = "$ERROR_MESSAGE $ex")
            }
        }
    }

    fun setDataArticulo() {
        viewModelScope.launch {
            try {
                val result: List<Articulo>? = getArticuloUseCase()
                _articulos.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())
            } catch (ex: kotlin.Exception) {
                _articulos.value = UiState.Error("$ERROR_MESSAGE $ex")
            }
        }
    }

    fun seleccionarCliente(cliente: ItemCard) {
        _pedido.value = _pedido.value.copy(clienteSeleccionado = cliente)
    }

    fun seleccionarArticulo(articulo: ItemCard) {
        _pedido.value = _pedido.value.copy(articuloSeleccionado = articulo)
    }
}