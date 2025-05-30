package com.axoft.tangopedidos.data.remote.api.pedido

import com.axoft.tangopedidos.data.remote.dto.PedidoResponse
import com.axoft.tangopedidos.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface PedidoClient {
    @GET(HttpRoutes.GET_PEDIDOS)
    suspend fun getAll(): Response<PedidoResponse>
}
