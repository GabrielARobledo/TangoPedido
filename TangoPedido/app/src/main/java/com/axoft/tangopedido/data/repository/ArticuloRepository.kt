package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.remote.api.articulo.ArticuloService
import com.axoft.tangopedido.data.remote.dto.Articulo
import javax.inject.Inject

class ArticuloRepository @Inject constructor(private val articuloService: ArticuloService) {
    suspend fun getAll(): List<Articulo>? {
        return articuloService.getAll()?.data?.toList()
    }
}