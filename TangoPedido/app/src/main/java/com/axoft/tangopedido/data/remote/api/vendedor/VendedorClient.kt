package com.axoft.tangopedido.data.remote.api.vendedor

import com.axoft.tangopedido.BuildConfig
import com.axoft.tangopedido.data.remote.dto.VendedorResponse
import com.axoft.tangopedido.data.remote.utils.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface VendedorClient {
    @GET(HttpRoutes.GET_VENDEDORES)
    suspend fun getAll(
        @Header("ApiAuthorization") token: String = BuildConfig.API_TOKEN,
        @Header("Company") company: Int = BuildConfig.API_COMPANY
    ): Response<VendedorResponse>
}
