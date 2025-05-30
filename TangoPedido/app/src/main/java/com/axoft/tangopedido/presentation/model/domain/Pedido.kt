package com.axoft.tangopedido.presentation.model.domain

import com.axoft.tangopedido.presentation.model.view.ItemCard
import com.axoft.tangopedido.presentation.model.view.RenglonCard

data class Pedido(
    val vendedorLogged: ItemCard? = null,
    val clienteSelected: ItemCard? = null,
    val articulos: List<RenglonCard> = emptyList(),
    val articuloSelected: ItemCard? = null
)