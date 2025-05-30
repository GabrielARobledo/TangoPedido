package com.axoft.axmobilepedidos.domain.usecase.articulo

import com.axoft.axmobilepedidos.data.repository.stock.ArticuloRepository
import com.axoft.axmobilepedidos.domain.model.stock.Articulo
import javax.inject.Inject

class GetArticulosUseCase @Inject constructor(private val articuloRepository: ArticuloRepository) {
    suspend operator fun invoke(): List<Articulo>? {
        return articuloRepository.getAll()?.toList()
    }
}
