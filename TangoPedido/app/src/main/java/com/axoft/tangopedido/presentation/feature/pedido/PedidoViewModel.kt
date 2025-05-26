package com.axoft.tangopedido.presentation.feature.pedido

import androidx.lifecycle.ViewModel
import com.axoft.tangopedido.data.repository.SessionRepository
import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.model.Pedido
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PedidoViewModel @Inject constructor(
    sessionRepository: SessionRepository
) : ViewModel() {

    private val _pedido = MutableStateFlow<Pedido>(Pedido())
    val pedido: StateFlow<Pedido> = _pedido.asStateFlow()

    init {
        _pedido.value = _pedido.value.copy(vendedorLogged = sessionRepository.getVendedor())
    }

    fun getNombreVendedorLogged(): String {
        return _pedido.value.vendedorLogged?.descripcion ?: ""
    }

    fun setCliente(cliente: ItemCard) {
        _pedido.value = _pedido.value.copy(clienteSelected = cliente)
    }

    fun setArticulo(articulo: ItemCard) {
        _pedido.value = _pedido.value.copy(articuloSelected = articulo)
    }
}