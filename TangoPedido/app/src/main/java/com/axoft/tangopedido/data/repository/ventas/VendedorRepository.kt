package com.axoft.tangopedido.data.repository.ventas

import com.axoft.tangopedido.data.mapper.ventas.toDomain
import com.axoft.tangopedido.data.remote.api.vendedor.VendedorService
import com.axoft.tangopedido.domain.model.ventas.Vendedor
import javax.inject.Inject

class VendedorRepository @Inject constructor(private val vendedorService: VendedorService) {
    suspend fun getAll(): List<Vendedor>? {
        val vendedorList = vendedorService.getAll()?.Items
        return vendedorList?.map { it.toDomain() }
    }
}
