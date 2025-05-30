package com.axoft.axmobilepedidos.data.remote.api.cliente

import com.axoft.axmobilepedidos.data.remote.dto.ClienteResponse
import retrofit2.Response
import javax.inject.Inject

class ClienteService @Inject constructor(private val clienteClient: ClienteClient) {
    @Throws(RuntimeException::class)
    suspend fun getAll(): ClienteResponse? {
        val response: Response<ClienteResponse> = clienteClient.getAll()

        return if (response.isSuccessful) {
            val body = response.body()
            println("Response body: $body")

            body

        } else {
            val errorBody = response.errorBody()?.string()
            throw java.lang.RuntimeException(errorBody)
        }
    }
}
