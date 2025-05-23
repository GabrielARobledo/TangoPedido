package com.axoft.tangopedido.domain.model

data class Articulo(
    val id: Int,
    val codigo: String?,
    val descripcion: String?,
    val descripcionAdicional: String?
)
