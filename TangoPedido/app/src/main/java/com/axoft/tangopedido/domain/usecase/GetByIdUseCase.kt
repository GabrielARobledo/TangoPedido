package com.axoft.tangopedido.domain.usecase

import com.axoft.tangopedido.data.remote.dto.GetByIdResponseDto
import com.axoft.tangopedido.data.repository.ClienteRepository
import javax.inject.Inject

class GetByIdUseCase @Inject constructor(private val repository: ClienteRepository) {
    suspend operator fun invoke(process: Int, id: Int, token: String, company: Int): GetByIdResponseDto? {
        return repository.getById(process, id, token, company)
    }
}