package com.axoft.tangopedido.presentation.model.view

data class RenglonCard(
    val id: Int,
    val codigo: String,
    val descripcion: String,
    val cantidadPedida: Float,
    val precio: Float,
    val importe: Float
)
