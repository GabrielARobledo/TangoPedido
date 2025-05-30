package com.axoft.axmobilepedidos.data.remote.api.cliente

import com.axoft.axmobilepedidos.data.remote.dto.ClienteResponse
import com.axoft.axmobilepedidos.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface ClienteClient {
    @GET(HttpRoutes.GET_CLIENTES)
    suspend fun getAll(): Response<ClienteResponse>
}
