package com.axoft.tangopedido.domain.usecase.vendedor

import com.axoft.tangopedido.data.repository.VendedorRepository
import com.axoft.tangopedido.domain.model.Vendedor
import javax.inject.Inject

class GetVendedoresUseCase @Inject constructor(private val vendedorRepository: VendedorRepository) {
    suspend operator fun invoke(): List<Vendedor>? {
        return vendedorRepository.getAll()
    }
}