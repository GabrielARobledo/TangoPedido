package com.axoft.tangopedido.domain.usecase.renglon

import com.axoft.tangopedido.data.repository.RenglonRepository
import javax.inject.Inject

class BorrarRenglonesUseCase @Inject constructor(
    private val repository: RenglonRepository
) {
    suspend operator fun invoke() {
        repository.borrarRenglones()
    }
}
