package com.axoft.tangopedido.presentation.model

data class Pedido(
    val vendedorLogged: ItemCard? = null,
    val clienteSelected: ItemCard? = null,
    val articulos: List<RenglonCard> = emptyList(),
    val articuloSelected: ItemCard? = null
)
