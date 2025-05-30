package com.axoft.axmobilepedidos.data.remote.api.articulo

import com.axoft.axmobilepedidos.data.remote.dto.ArticuloResponse
import com.axoft.axmobilepedidos.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface ArticuloClient {
    @GET(HttpRoutes.GET_ARTICULOS)
    suspend fun getAll(): Response<ArticuloResponse>
}
