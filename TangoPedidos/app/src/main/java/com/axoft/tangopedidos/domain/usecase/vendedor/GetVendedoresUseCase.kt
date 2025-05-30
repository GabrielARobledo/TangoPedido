package com.axoft.tangopedidos.domain.usecase.vendedor

import com.axoft.tangopedidos.data.repository.ventas.VendedorRepository
import com.axoft.tangopedidos.domain.model.ventas.Vendedor
import javax.inject.Inject

class GetVendedoresUseCase @Inject constructor(private val vendedorRepository: VendedorRepository) {
    suspend operator fun invoke(): List<Vendedor>? {
        return vendedorRepository.getAll()
    }
}