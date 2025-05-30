package com.axoft.axmobilepedidos.data.repository.ventas

import com.axoft.axmobilepedidos.data.mapper.ventas.toDomain
import com.axoft.axmobilepedidos.data.remote.api.pedido.PedidoService
import com.axoft.axmobilepedidos.domain.model.ventas.Pedido
import javax.inject.Inject

class PedidoRepository @Inject constructor(private val pedidoService: PedidoService) {
    suspend fun getAll(): List<Pedido>? {
        val pedidoList = pedidoService.getAll()?.Items
        return pedidoList?.map { it.toDomain() }
    }
}
