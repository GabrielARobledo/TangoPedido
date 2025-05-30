package com.axoft.axmobilepedidos.data.remote.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class PedidoResponse(
    @SerializedName("items") val Items: List<PedidoDto>
)

data class PedidoDto(
    @SerializedName("id") val id: Int,
    @SerializedName("fecha") val fecha: String?,
    @SerializedName("talonario") val talonario: Short,
    @SerializedName("numeroPedido") val numeroPedido: String,
    @SerializedName("codigoCliente") val codigoCliente: String,
    @SerializedName("razonSocialCliente") val razonSocialCliente: String,
    @SerializedName("total") val total: BigDecimal
)
