package com.axoft.axmobilepedidos.domain.usecase.vendedor

import com.axoft.axmobilepedidos.data.repository.ventas.VendedorRepository
import com.axoft.axmobilepedidos.domain.model.ventas.Vendedor
import javax.inject.Inject

class GetVendedoresUseCase @Inject constructor(private val vendedorRepository: VendedorRepository) {
    suspend operator fun invoke(): List<Vendedor>? {
        return vendedorRepository.getAll()
    }
}