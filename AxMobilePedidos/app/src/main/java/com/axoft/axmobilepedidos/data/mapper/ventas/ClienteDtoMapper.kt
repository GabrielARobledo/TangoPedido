package com.axoft.axmobilepedidos.data.mapper.ventas

import com.axoft.axmobilepedidos.data.remote.dto.ClienteDto
import com.axoft.axmobilepedidos.domain.model.ventas.Cliente

fun ClienteDto.toDomain(): Cliente {
    return Cliente(
        id = this.id,
        codigo = this.codigo,
        razonSocial = this.razonSocial
    )
}
