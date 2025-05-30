package com.axoft.tangopedido.data.mapper.stock

import com.axoft.tangopedido.data.remote.dto.ArticuloDto
import com.axoft.tangopedido.domain.model.stock.Articulo

fun ArticuloDto.toDomain(): Articulo {
    return Articulo(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.descripcion,
        descripcionAdicional = this.descripcionAdicional
    )
}
