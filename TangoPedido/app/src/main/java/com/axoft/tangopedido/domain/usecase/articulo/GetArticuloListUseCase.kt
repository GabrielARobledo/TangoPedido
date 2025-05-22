package com.axoft.tangopedido.domain.usecase.articulo

import com.axoft.tangopedido.data.remote.dto.Articulo
import com.axoft.tangopedido.data.repository.ArticuloRepository
import javax.inject.Inject

class GetArticuloListUseCase @Inject constructor(private val articuloRepository: ArticuloRepository) {
    suspend operator fun invoke(): List<Articulo>? {
        return articuloRepository.getAll()?.toList()
    }
}