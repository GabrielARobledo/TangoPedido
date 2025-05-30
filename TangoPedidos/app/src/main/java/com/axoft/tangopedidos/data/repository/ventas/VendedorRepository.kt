package com.axoft.tangopedidos.data.repository.ventas

import com.axoft.tangopedidos.data.mapper.ventas.toDomain
import com.axoft.tangopedidos.data.remote.api.vendedor.VendedorService
import com.axoft.tangopedidos.domain.model.ventas.Vendedor
import javax.inject.Inject

class VendedorRepository @Inject constructor(private val vendedorService: VendedorService) {
    suspend fun getAll(): List<Vendedor>? {
        val vendedorList = vendedorService.getAll()?.Items
        return vendedorList?.map { it.toDomain() }
    }
}
