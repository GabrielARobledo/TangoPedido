package com.axoft.tangopedidos.data.repository.ventas

import com.axoft.tangopedidos.data.mapper.ventas.toDomain
import com.axoft.tangopedidos.data.remote.api.pedido.PedidoService
import com.axoft.tangopedidos.domain.model.ventas.Pedido
import javax.inject.Inject

class PedidoRepository @Inject constructor(private val pedidoService: PedidoService) {
    suspend fun getAll(): List<Pedido>? {
        val pedidoList = pedidoService.getAll()?.Items
        return pedidoList?.map { it.toDomain() }
    }
}
