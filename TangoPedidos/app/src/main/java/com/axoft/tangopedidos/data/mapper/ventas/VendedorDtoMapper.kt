package com.axoft.tangopedidos.data.mapper.ventas

import com.axoft.tangopedidos.data.remote.dto.VendedorDto
import com.axoft.tangopedidos.domain.model.ventas.Vendedor

fun VendedorDto.toDomain(): Vendedor {
    return Vendedor(
        id = this.id,
        codigo = this.codigo,
        nombre = this.nombre
    )
}
