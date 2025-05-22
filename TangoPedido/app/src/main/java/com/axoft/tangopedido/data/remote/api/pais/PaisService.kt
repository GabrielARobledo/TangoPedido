package com.axoft.tangopedido.data.remote.api.pais

import com.axoft.tangopedido.data.remote.dto.PaisResponse
import retrofit2.Response
import javax.inject.Inject

class PaisService @Inject constructor(private val paisClient: PaisClient) {
    suspend fun GetPaisById(id: Int): PaisResponse? {
        val response: Response<PaisResponse> = paisClient.GetPaisById(id = id)

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
