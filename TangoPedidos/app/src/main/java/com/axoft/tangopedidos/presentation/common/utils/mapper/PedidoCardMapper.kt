package com.axoft.tangopedidos.presentation.common.utils.mapper

import com.axoft.tangopedidos.domain.model.ventas.Pedido
import com.axoft.tangopedidos.presentation.model.view.PedidoUi

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
