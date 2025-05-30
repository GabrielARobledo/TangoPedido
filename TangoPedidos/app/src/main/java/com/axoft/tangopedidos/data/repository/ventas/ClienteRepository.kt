package com.axoft.tangopedidos.data.repository.ventas

import com.axoft.tangopedidos.data.mapper.ventas.toDomain
import com.axoft.tangopedidos.data.remote.api.cliente.ClienteService
import com.axoft.tangopedidos.domain.model.ventas.Cliente
import javax.inject.Inject

class ClienteRepository @Inject constructor(private val clienteService: ClienteService) {
    suspend fun getAll(): List<Cliente>? {
        val clienteList = clienteService.getAll()?.Items
        return clienteList?.map { it.toDomain() }
    }
}
