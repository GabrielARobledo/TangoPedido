package com.axoft.tangopedido.data.remote.api.cliente

import com.axoft.tangopedido.data.remote.dto.ClienteResponse
import com.axoft.tangopedido.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface ClienteClient {
    @GET(HttpRoutes.GET_CLIENTES)
    suspend fun getAll(): Response<ClienteResponse>
}
