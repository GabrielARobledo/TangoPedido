package com.axoft.tangopedidos.data.mapper.ventas

import com.axoft.tangopedidos.data.remote.dto.ClienteDto
import com.axoft.tangopedidos.domain.model.ventas.Cliente

fun ClienteDto.toDomain(): Cliente {
    return Cliente(
        id = this.id,
        codigo = this.codigo,
        razonSocial = this.razonSocial
    )
}
