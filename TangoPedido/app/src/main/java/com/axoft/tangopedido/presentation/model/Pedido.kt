package com.axoft.tangopedido.presentation.model

import com.axoft.tangopedido.domain.model.Vendedor

data class Pedido(
    val vendedorLogged: Vendedor? = null,
    val clienteSeleccionado: ItemCard? = null,
    val articuloSeleccionado: ItemCard? = null
)