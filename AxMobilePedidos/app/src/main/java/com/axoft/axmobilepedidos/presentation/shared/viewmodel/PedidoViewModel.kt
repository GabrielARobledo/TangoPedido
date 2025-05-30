package com.axoft.axmobilepedidos.presentation.shared.viewmodel

import androidx.lifecycle.ViewModel
import com.axoft.axmobilepedidos.data.repository.app.SessionRepository
import com.axoft.axmobilepedidos.presentation.common.utils.mapper.toRenglonCard
import com.axoft.axmobilepedidos.presentation.model.domain.Pedido
import com.axoft.axmobilepedidos.presentation.model.view.ItemCard
import com.axoft.axmobilepedidos.presentation.model.view.RenglonUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * PedidoViewModel
 *
 * ViewModel global que gestiona el estado compartido del pedido en construcción
 * dentro de la aplicación. Mantiene y expone los datos principales del pedido
 * (vendedor logueado, cliente seleccionado, artículos agregados) usando un StateFlow.
 *
 * @param sessionRepository Repositorio que provee datos de sesión (vendedor autenticado).
 */
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
        val renglonCard: RenglonUi = articulo.toRenglonCard()
        val pedidoActual = _pedido.value
        val nuevaLista = pedidoActual.renglones + renglonCard
        _pedido.value = pedidoActual.copy(
            renglones = nuevaLista,
            articuloSelected = articulo
        )
    }
}
