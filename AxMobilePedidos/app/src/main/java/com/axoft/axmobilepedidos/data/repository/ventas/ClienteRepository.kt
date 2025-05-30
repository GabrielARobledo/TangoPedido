package com.axoft.axmobilepedidos.data.repository.ventas

import com.axoft.axmobilepedidos.data.mapper.ventas.toDomain
import com.axoft.axmobilepedidos.data.remote.api.cliente.ClienteService
import com.axoft.axmobilepedidos.domain.model.ventas.Cliente
import javax.inject.Inject

class ClienteRepository @Inject constructor(private val clienteService: ClienteService) {
    suspend fun getAll(): List<Cliente>? {
        val clienteList = clienteService.getAll()?.Items
        return clienteList?.map { it.toDomain() }
    }
}
