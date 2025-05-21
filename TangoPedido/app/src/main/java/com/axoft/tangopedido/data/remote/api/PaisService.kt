package com.axoft.tangopedido.data.remote.api

import com.axoft.tangopedido.data.remote.dto.PaisResponse
import javax.inject.Inject

class PaisService @Inject constructor(private val paisClient: PaisClient) {
    suspend fun getById(process: Int, id: Int, token: String, company: Int): PaisResponse? {
        val response = paisClient.getById(process = process, id = id, token = token, company = company)

        return if (response.isSuccessful) {
            val body = response.body()
            println("Response body: $body")

            body

        } else {
            val errorBody = response.errorBody()?.string()
            println("Error response body: $errorBody")

            null
        }
    }
}