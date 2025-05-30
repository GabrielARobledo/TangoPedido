package com.axoft.tangopedido.data.mapper.ventas

import com.axoft.tangopedido.data.remote.dto.VendedorDto
import com.axoft.tangopedido.domain.model.ventas.Vendedor

fun VendedorDto.toDomain(): Vendedor {
    return Vendedor(
        id = this.id,
        codigo = this.codigo,
        nombre = this.nombre
    )
}
