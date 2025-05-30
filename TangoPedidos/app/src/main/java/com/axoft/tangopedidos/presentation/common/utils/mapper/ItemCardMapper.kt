package com.axoft.tangopedidos.presentation.common.utils.mapper

import com.axoft.tangopedidos.domain.model.stock.Articulo
import com.axoft.tangopedidos.domain.model.ventas.Cliente
import com.axoft.tangopedidos.domain.model.ventas.Vendedor
import com.axoft.tangopedidos.presentation.model.view.ItemCard

fun Articulo.toSimpleItem(): ItemCard {
    return ItemCard(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.descripcion
    )
}

fun Cliente.toSimpleItem(): ItemCard {
    return ItemCard(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.razonSocial
    )
}

fun Vendedor.toSimpleItem(): ItemCard {
    return ItemCard(
        id = id,
        codigo = this.codigo,
        descripcion = this.nombre
    )
}
