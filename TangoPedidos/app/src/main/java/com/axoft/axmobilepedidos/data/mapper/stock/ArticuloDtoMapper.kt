package com.axoft.tangopedidos.data.mapper.stock

import com.axoft.tangopedidos.data.remote.dto.ArticuloDto
import com.axoft.tangopedidos.domain.model.stock.Articulo

fun ArticuloDto.toDomain(): Articulo {
    return Articulo(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.descripcion,
        descripcionAdicional = this.descripcionAdicional
    )
}
