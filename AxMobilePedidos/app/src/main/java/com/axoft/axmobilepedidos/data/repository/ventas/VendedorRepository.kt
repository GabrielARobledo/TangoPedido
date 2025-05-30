package com.axoft.axmobilepedidos.data.repository.ventas

import com.axoft.axmobilepedidos.data.mapper.ventas.toDomain
import com.axoft.axmobilepedidos.data.remote.api.vendedor.VendedorService
import com.axoft.axmobilepedidos.domain.model.ventas.Vendedor
import javax.inject.Inject

class VendedorRepository @Inject constructor(private val vendedorService: VendedorService) {
    suspend fun getAll(): List<Vendedor>? {
        val vendedorList = vendedorService.getAll()?.Items
        return vendedorList?.map { it.toDomain() }
    }
}
