package com.axoft.tangopedido.domain.usecase.pais

import com.axoft.tangopedido.data.remote.dto.PaisResponse
import com.axoft.tangopedido.data.repository.PaisRepository
import javax.inject.Inject

class GetPaisByIdUseCase @Inject constructor(private val repository: PaisRepository) {
    suspend operator fun invoke(id: Int): PaisResponse? {
        return repository.getById(id = id)
    }
}