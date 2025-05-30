package com.axoft.tangopedidos.data.remote.api.articulo

import com.axoft.tangopedidos.data.remote.dto.ArticuloResponse
import com.axoft.tangopedidos.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface ArticuloClient {
    @GET(HttpRoutes.GET_ARTICULOS)
    suspend fun getAll(): Response<ArticuloResponse>
}
