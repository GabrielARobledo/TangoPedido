package com.axoft.tangopedido.data.mapper.ventas

import com.axoft.tangopedido.data.remote.dto.ClienteDto
import com.axoft.tangopedido.domain.model.ventas.Cliente

fun ClienteDto.toDomain(): Cliente {
    return Cliente(
        id = this.id,
        codigo = this.codigo,
        razonSocial = this.razonSocial
    )
}
