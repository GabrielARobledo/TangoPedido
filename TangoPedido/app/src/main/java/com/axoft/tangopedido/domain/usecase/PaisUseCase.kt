package com.axoft.tangopedido.domain.usecase

import com.axoft.tangopedido.data.remote.dto.PaisResponse
import com.axoft.tangopedido.data.repository.PaisRepository
import javax.inject.Inject

class PaisUseCase @Inject constructor(private val repository: PaisRepository) {
    suspend operator fun invoke(process: Int, id: Int, token: String, company: Int): PaisResponse? {
        return repository.getById(process, id, token, company)
    }
}