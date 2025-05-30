package com.axoft.axmobilepedidos.presentation.common.utils.mapper

import com.axoft.axmobilepedidos.domain.model.ventas.Pedido
import com.axoft.axmobilepedidos.presentation.model.view.PedidoUi

fun Pedido.toPedidoUi(): PedidoUi {
    return PedidoUi(
        id = this.id,
        fecha = this.fecha,
        talonario = this.talonario,
        numeroPedido = this.numeroPedido,
        codigoCliente = this.codigoCliente,
        razonSocialCliente = this.razonSocialCliente,
        total = this.total
    )
}
