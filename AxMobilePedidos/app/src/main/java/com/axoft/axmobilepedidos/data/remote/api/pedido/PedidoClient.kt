package com.axoft.axmobilepedidos.data.remote.api.pedido

import com.axoft.axmobilepedidos.data.remote.dto.PedidoResponse
import com.axoft.axmobilepedidos.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface PedidoClient {
    @GET(HttpRoutes.GET_PEDIDOS)
    suspend fun getAll(): Response<PedidoResponse>
}
