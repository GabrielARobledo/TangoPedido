package com.axoft.axmobilepedidos.data.remote.api.articulo

import com.axoft.axmobilepedidos.data.remote.dto.ArticuloResponse
import retrofit2.Response
import javax.inject.Inject

class ArticuloService @Inject constructor(private val articuloClient: ArticuloClient) {
    suspend fun getAll(): ArticuloResponse? {
        val response: Response<ArticuloResponse> = articuloClient.getAll()

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
