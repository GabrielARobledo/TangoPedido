package com.axoft.tangopedido.presentation.mapper

import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.model.RenglonCard

fun ItemCard.toRenglonCard(): RenglonCard {
    return RenglonCard(
        id = this.id,
        codigo = this.codigo ?: "",
        descripcion = this.descripcion ?: "",
        cantidadPedida = 0f,
        precio = 0f,
        importe = 0f
    )
}
