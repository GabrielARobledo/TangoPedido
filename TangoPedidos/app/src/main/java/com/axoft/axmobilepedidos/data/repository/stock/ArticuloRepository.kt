package com.axoft.tangopedidos.data.repository.stock

import com.axoft.tangopedidos.data.mapper.stock.toDomain
import com.axoft.tangopedidos.data.remote.api.articulo.ArticuloService
import com.axoft.tangopedidos.domain.model.stock.Articulo
import javax.inject.Inject

class ArticuloRepository @Inject constructor(private val articuloService: ArticuloService) {
    suspend fun getAll(): List<Articulo>? {
        val articuloList = articuloService.getAll()?.data
        return articuloList?.map { it.toDomain() } ?: emptyList()
    }
}