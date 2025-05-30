package com.axoft.axmobilepedidos.presentation.common.utils.mapper

import com.axoft.axmobilepedidos.presentation.model.view.ItemCard
import com.axoft.axmobilepedidos.presentation.model.view.RenglonUi

fun ItemCard.toRenglonCard(): RenglonUi {
    return RenglonUi(
        id = this.id,
        codigo = this.codigo ?: "",
        descripcion = this.descripcion ?: "",
        cantidadPedida = 0f,
        precio = 0f,
        importe = 0f
    )
}
