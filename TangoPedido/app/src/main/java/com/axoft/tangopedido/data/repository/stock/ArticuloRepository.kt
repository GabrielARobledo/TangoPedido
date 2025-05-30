package com.axoft.tangopedido.data.repository.stock

import com.axoft.tangopedido.data.mapper.stock.toDomain
import com.axoft.tangopedido.data.mapper.ventas.toDomain
import com.axoft.tangopedido.data.remote.api.articulo.ArticuloService
import com.axoft.tangopedido.domain.model.stock.Articulo
import javax.inject.Inject

class ArticuloRepository @Inject constructor(private val articuloService: ArticuloService) {
    suspend fun getAll(): List<Articulo>? {
        val articuloList = articuloService.getAll()?.data
        return articuloList?.map { it.toDomain() } ?: emptyList()
    }
}