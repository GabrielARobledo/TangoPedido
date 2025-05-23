package com.axoft.tangopedido.domain.usecase.pais

import com.axoft.tangopedido.data.repository.ClienteRepository
import com.axoft.tangopedido.domain.model.Cliente
import javax.inject.Inject

class GetClientesUseCase @Inject constructor(private val clienteRepository: ClienteRepository) {
    suspend operator fun invoke(): List<Cliente>? {
        return clienteRepository.getAll()
    }
}