package com.axoft.tangopedido.presentation.common.utils.mapper

import com.axoft.tangopedido.domain.model.ventas.Pedido
import com.axoft.tangopedido.presentation.model.view.PedidoUi

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
