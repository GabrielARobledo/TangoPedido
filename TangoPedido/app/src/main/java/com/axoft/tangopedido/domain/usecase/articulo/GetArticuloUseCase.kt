package com.axoft.tangopedido.domain.usecase.articulo

import com.axoft.tangopedido.data.repository.ArticuloRepository
import com.axoft.tangopedido.domain.model.Articulo
import javax.inject.Inject

class GetArticulosUseCase @Inject constructor(private val articuloRepository: ArticuloRepository) {
    suspend operator fun invoke(): List<Articulo>? {
        return articuloRepository.getAll()?.toList()
    }
}