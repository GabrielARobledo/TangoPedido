package com.axoft.tangopedidos.domain.usecase.pedido

import com.axoft.tangopedidos.data.repository.ventas.PedidoRepository
import com.axoft.tangopedidos.domain.model.ventas.Pedido
import javax.inject.Inject

class GetPedidosUseCase @Inject constructor(private val pedidoRepository: PedidoRepository) {
    suspend operator fun invoke(): List<Pedido> {
        return pedidoRepository.getAll() ?: emptyList()
    }
}
