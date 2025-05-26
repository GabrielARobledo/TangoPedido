package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.mapper.toDomain
import com.axoft.tangopedido.data.remote.api.cliente.ClienteService
import com.axoft.tangopedido.domain.model.Cliente
import javax.inject.Inject

class ClienteRepository @Inject constructor(private val clienteService: ClienteService) {
    suspend fun getAll(): List<Cliente>? {
        val clienteList = clienteService.getAll()?.Items
        return clienteList?.map { it.toDomain() }
    }
}
