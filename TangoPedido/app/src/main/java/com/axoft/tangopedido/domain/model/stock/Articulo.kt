package com.axoft.tangopedido.domain.model.stock

data class Articulo(
    val id: Int,
    val codigo: String?,
    val descripcion: String?,
    val descripcionAdicional: String?
)