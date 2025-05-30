package com.axoft.tangopedido.presentation.common.utils.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import com.axoft.tangopedido.domain.model.stock.Articulo
import com.axoft.tangopedido.domain.model.ventas.Cliente
import com.axoft.tangopedido.domain.model.ventas.Vendedor
import com.axoft.tangopedido.presentation.model.view.ItemCard

fun Articulo.toSimpleItem(): ItemCard {
    return ItemCard(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.descripcion,
        icon = Icons.Default.Star
    )
}

fun Cliente.toSimpleItem(): ItemCard {
    return ItemCard(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.razonSocial,
        icon = Icons.Default.Person
    )
}

fun Vendedor.toSimpleItem(): ItemCard {
    return ItemCard(
        id = id,
        codigo = this.codigo,
        descripcion = this.nombre,
        icon = Icons.Default.Person
    )
}
