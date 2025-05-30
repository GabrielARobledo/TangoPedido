package com.axoft.axmobilepedidos.data.mapper.ventas

import android.os.Build
import androidx.annotation.RequiresApi
import com.axoft.axmobilepedidos.data.remote.dto.PedidoDto
import com.axoft.axmobilepedidos.domain.model.ventas.Pedido
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun PedidoDto.toDomain(): Pedido {
    val fechaFormateada = LocalDateTime.parse(this.fecha).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    return Pedido(
        id = this.id,
        fecha = fechaFormateada,
        talonario = this.talonario,
        numeroPedido = this.numeroPedido,
        codigoCliente = this.codigoCliente,
        razonSocialCliente = this.razonSocialCliente,
        total = this.total
    )
}