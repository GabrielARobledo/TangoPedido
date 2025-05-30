package com.axoft.axmobilepedidos.domain.usecase.pedido

import com.axoft.axmobilepedidos.data.repository.ventas.PedidoRepository
import com.axoft.axmobilepedidos.domain.model.ventas.Pedido
import javax.inject.Inject

class GetPedidosUseCase @Inject constructor(private val pedidoRepository: PedidoRepository) {
    suspend operator fun invoke(): List<Pedido> {
        return pedidoRepository.getAll() ?: emptyList()
    }
}
