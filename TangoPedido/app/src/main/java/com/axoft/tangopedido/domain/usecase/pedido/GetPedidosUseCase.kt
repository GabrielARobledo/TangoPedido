package com.axoft.tangopedido.domain.usecase.pedido

import com.axoft.tangopedido.data.repository.ventas.PedidoRepository
import com.axoft.tangopedido.domain.model.ventas.Pedido
import javax.inject.Inject

class GetPedidosUseCase @Inject constructor(private val pedidoRepository: PedidoRepository) {
    suspend operator fun invoke(): List<Pedido> {
        return pedidoRepository.getAll() ?: emptyList()
    }
}
