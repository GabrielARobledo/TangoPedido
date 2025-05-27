package com.axoft.tangopedido.domain.usecase.renglon

import com.axoft.tangopedido.data.local.entities.RenglonEntity
import com.axoft.tangopedido.data.repository.RenglonRepository
import javax.inject.Inject

class ObtenerRenglonesUseCase @Inject constructor(
    private val repository: RenglonRepository
) {
    suspend operator fun invoke(): List<RenglonEntity> {
        return repository.obtenerRenglones()
    }
}
