package com.axoft.tangopedido.data.remote.api.pedido

import com.axoft.tangopedido.data.remote.dto.PedidoResponse
import com.axoft.tangopedido.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface PedidoClient {
    @GET(HttpRoutes.GET_PEDIDOS)
    suspend fun getAll(): Response<PedidoResponse>
}
