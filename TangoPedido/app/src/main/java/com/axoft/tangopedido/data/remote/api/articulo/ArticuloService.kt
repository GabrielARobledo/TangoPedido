package com.axoft.tangopedido.data.remote.api.articulo

import com.axoft.tangopedido.data.remote.dto.ArticuloResponse
import retrofit2.Response
import javax.inject.Inject

class ArticuloService @Inject constructor(private val articuloClient: ArticuloClient ) {
    suspend fun getAll() : ArticuloResponse? {
        val response: Response<ArticuloResponse> = articuloClient.getAll()

        return if (response.isSuccessful) response.body() else null
    }
}