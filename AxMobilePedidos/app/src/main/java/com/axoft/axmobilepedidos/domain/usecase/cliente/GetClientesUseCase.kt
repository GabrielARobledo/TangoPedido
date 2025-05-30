package com.axoft.axmobilepedidos.domain.usecase.cliente

import com.axoft.axmobilepedidos.data.repository.ventas.ClienteRepository
import com.axoft.axmobilepedidos.domain.model.ventas.Cliente
import javax.inject.Inject

class GetClientesUseCase @Inject constructor(private val clienteRepository: ClienteRepository) {
    suspend operator fun invoke(): List<Cliente>? {
        return clienteRepository.getAll()
    }
}
