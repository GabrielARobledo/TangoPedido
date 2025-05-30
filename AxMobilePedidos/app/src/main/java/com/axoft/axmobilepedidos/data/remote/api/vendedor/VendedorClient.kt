package com.axoft.axmobilepedidos.data.remote.api.vendedor

import com.axoft.axmobilepedidos.data.remote.dto.VendedorResponse
import com.axoft.axmobilepedidos.data.remote.network.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET

interface VendedorClient {
    @GET(HttpRoutes.GET_VENDEDORES)
    suspend fun getAll(): Response<VendedorResponse>
}
