package com.axoft.tangopedido.presentation.feature.pedido.viewmodel

import androidx.lifecycle.ViewModel
import com.axoft.tangopedido.data.repository.app.SessionRepository
import com.axoft.tangopedido.presentation.common.utils.mapper.toRenglonCard
import com.axoft.tangopedido.presentation.model.domain.Pedido
import com.axoft.tangopedido.presentation.model.view.ItemCard
import com.axoft.tangopedido.presentation.model.view.RenglonCard
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

    fun addArticulo(articulo: ItemCard) {
        val renglonCard: RenglonCard = articulo.toRenglonCard()
        val pedidoActual = _pedido.value
        val nuevaLista = pedidoActual.articulos + renglonCard
        _pedido.value = pedidoActual.copy(
            articulos = nuevaLista,
            articuloSelected = articulo
        )
    }
}