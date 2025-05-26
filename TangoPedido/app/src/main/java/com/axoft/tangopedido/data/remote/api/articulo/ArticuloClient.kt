package com.axoft.tangopedido.data.remote.api.articulo

import com.axoft.tangopedido.BuildConfig
import com.axoft.tangopedido.data.remote.dto.ArticuloResponse
import com.axoft.tangopedido.data.remote.utils.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ArticuloClient {
    @GET(HttpRoutes.GET_ARTICULOS)
    suspend fun getAll(
        @Header("ApiAuthorization") token: String = BuildConfig.API_TOKEN,
        @Header("Company") company: Int = BuildConfig.API_COMPANY
    ): Response<ArticuloResponse>
}
