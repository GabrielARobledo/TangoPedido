package com.axoft.axmobilepedidos.data.mapper.stock

import com.axoft.axmobilepedidos.data.remote.dto.ArticuloDto
import com.axoft.axmobilepedidos.domain.model.stock.Articulo

fun ArticuloDto.toDomain(): Articulo {
    return Articulo(
        id = this.id,
        codigo = this.codigo,
        descripcion = this.descripcion,
        descripcionAdicional = this.descripcionAdicional
    )
}
