package com.axoft.tangopedidos.domain.usecase.articulo

import com.axoft.tangopedidos.data.repository.stock.ArticuloRepository
import com.axoft.tangopedidos.domain.model.stock.Articulo
import javax.inject.Inject

class GetArticulosUseCase @Inject constructor(private val articuloRepository: ArticuloRepository) {
    suspend operator fun invoke(): List<Articulo>? {
        return articuloRepository.getAll()?.toList()
    }
}
