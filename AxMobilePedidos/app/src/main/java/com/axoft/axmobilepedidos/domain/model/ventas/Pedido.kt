package com.axoft.axmobilepedidos.domain.model.ventas

import java.math.BigDecimal

data class Pedido(
    val id: Int,
    val fecha: String?,
    val talonario: Short,
    val numeroPedido: String,
    val codigoCliente: String,
    val razonSocialCliente: String,
    val total: BigDecimal
)
