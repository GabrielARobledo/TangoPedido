package com.axoft.tangopedido.data.repository.ventas

import com.axoft.tangopedido.data.mapper.ventas.toDomain
import com.axoft.tangopedido.data.remote.api.pedido.PedidoService
import com.axoft.tangopedido.domain.model.ventas.Pedido
import javax.inject.Inject

class PedidoRepository @Inject constructor(private val pedidoService: PedidoService) {
    suspend fun getAll(): List<Pedido>? {
        val pedidoList = pedidoService.getAll()?.Items
        return pedidoList?.map { it.toDomain() }
    }
}
