package com.axoft.tangopedido.data.remote.api

import com.axoft.tangopedido.data.remote.dto.GetByIdResponseDto
import javax.inject.Inject

class ClientService @Inject constructor(private val clienteRequest: ClienteRequest) {
    suspend fun getById(process: Int, id: Int, token: String, company: Int): GetByIdResponseDto? {
        val response = clienteRequest.getById(process = process, id = id, token = token, company = company)

        return if (response.isSuccessful) {
            val body = response.body()
            println("Response body: $body")

            // podés acceder a los datos deserializados directamente
            val razonSocial = body?.value?.RAZON_SOCI
            println("Razón social: $razonSocial")

            body // <- objeto ClienteResponse

        } else {
            val errorBody = response.errorBody()?.string()
            println("Error response body: $errorBody")

            null
        }

        //return if (response.isSuccessful) response.body() else null
    }
}