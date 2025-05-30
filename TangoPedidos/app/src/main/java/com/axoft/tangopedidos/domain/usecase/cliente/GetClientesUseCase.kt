package com.axoft.tangopedidos.domain.usecase.cliente

import com.axoft.tangopedidos.data.repository.ventas.ClienteRepository
import com.axoft.tangopedidos.domain.model.ventas.Cliente
import javax.inject.Inject

class GetClientesUseCase @Inject constructor(private val clienteRepository: ClienteRepository) {
    suspend operator fun invoke(): List<Cliente>? {
        return clienteRepository.getAll()
    }
}
