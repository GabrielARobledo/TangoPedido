package com.axoft.tangopedido.data.remote.api.vendedor

import com.axoft.tangopedido.data.remote.dto.VendedorResponse
import com.axoft.tangopedido.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface VendedorClient {
    @GET(HttpRoutes.GET_VENDEDORES)
    suspend fun getAll(): Response<VendedorResponse>
}
