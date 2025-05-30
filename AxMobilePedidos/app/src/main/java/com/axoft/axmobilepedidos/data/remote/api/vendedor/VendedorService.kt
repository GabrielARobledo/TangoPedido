package com.axoft.axmobilepedidos.data.remote.api.vendedor

import com.axoft.axmobilepedidos.data.remote.dto.VendedorResponse
import retrofit2.Response
import javax.inject.Inject

class VendedorService @Inject constructor(private val vendedorClient: VendedorClient) {
    @Throws(RuntimeException::class)
    suspend fun getAll(): VendedorResponse? {
        val response: Response<VendedorResponse> = vendedorClient.getAll()

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
