package com.axoft.tangopedido.data.mapper

import com.axoft.tangopedido.data.remote.dto.ClienteDto
import com.axoft.tangopedido.domain.model.Cliente

fun ClienteDto.toDomain(): Cliente {
    return Cliente(
        id = this.id,
        codigo = this.codigo,
        razonSocial = this.razonSocial
    )
}
