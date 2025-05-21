package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.remote.api.ClientService
import com.axoft.tangopedido.data.remote.dto.GetByIdResponseDto
import javax.inject.Inject

class ClienteRepository @Inject constructor (private val clientService: ClientService) {
    suspend fun getById(process: Int, id: Int, token: String, company: Int): GetByIdResponseDto? {
        return clientService.getById(process = process, id = id, token = token, company = company)
    }
}