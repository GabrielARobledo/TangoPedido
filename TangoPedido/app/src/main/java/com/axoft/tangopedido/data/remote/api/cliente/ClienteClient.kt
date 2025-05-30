package com.axoft.tangopedido.data.remote.api.cliente

import com.axoft.tangopedido.BuildConfig
import com.axoft.tangopedido.data.remote.dto.ClienteResponse
import com.axoft.tangopedido.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ClienteClient {
    @GET(HttpRoutes.GET_CLIENTES)
    suspend fun getAll(
        @Header("ApiAuthorization") token: String = BuildConfig.API_TOKEN,
        @Header("Company") company: Int = BuildConfig.API_COMPANY
    ): Response<ClienteResponse>
}
