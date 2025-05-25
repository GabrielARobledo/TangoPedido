package com.axoft.tangopedido.presentation.mapper

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import com.axoft.tangopedido.domain.model.Articulo
import com.axoft.tangopedido.domain.model.Cliente
import com.axoft.tangopedido.domain.model.Vendedor
import com.axoft.tangopedido.presentation.model.ItemCard

fun Articulo.toSimpleItem(): ItemCard {
    return ItemCard(
        id = this.id,
        label = "Artículo",
        codigo = this.codigo,
        descripcion = this.descripcion,
        icon = Icons.Default.Star
    )
}

fun Cliente.toSimpleItem(): ItemCard {
    return ItemCard(
        id = this.id,
        label = "Cliente",
        codigo = this.codigo,
        descripcion = this.razonSocial,
        icon = Icons.Default.Person
    )
}

fun Vendedor.toSimpleItem(): ItemCard {
    return ItemCard(
        id = id,
        label = "Vendedor",
        codigo = this.codigo,
        descripcion = this.nombre,
        icon = Icons.Default.Person
    )
}
