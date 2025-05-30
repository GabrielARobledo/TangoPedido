package com.axoft.axmobilepedidos.presentation.model.view

import java.math.BigDecimal

data class PedidoUi(
    val id: Int,
    val fecha: String?,
    val talonario: Short,
    val numeroPedido: String,
    val codigoCliente: String,
    val razonSocialCliente: String,
    val total: BigDecimal
)
