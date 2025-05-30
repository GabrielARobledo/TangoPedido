package com.axoft.axmobilepedidos.data.mapper.ventas

import com.axoft.axmobilepedidos.data.remote.dto.VendedorDto
import com.axoft.axmobilepedidos.domain.model.ventas.Vendedor

fun VendedorDto.toDomain(): Vendedor {
    return Vendedor(
        id = this.id,
        codigo = this.codigo,
        nombre = this.nombre
    )
}
