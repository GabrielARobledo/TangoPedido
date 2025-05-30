package com.axoft.tangopedido.domain.usecase.vendedor

import com.axoft.tangopedido.data.repository.ventas.VendedorRepository
import com.axoft.tangopedido.domain.model.ventas.Vendedor
import javax.inject.Inject

class GetVendedoresUseCase @Inject constructor(private val vendedorRepository: VendedorRepository) {
    suspend operator fun invoke(): List<Vendedor>? {
        return vendedorRepository.getAll()
    }
}