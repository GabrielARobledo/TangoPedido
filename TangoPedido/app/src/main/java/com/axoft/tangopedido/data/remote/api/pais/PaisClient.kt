package com.axoft.tangopedido.data.remote.api.pais

import com.axoft.tangopedido.BuildConfig
import com.axoft.tangopedido.data.remote.dto.PaisResponse
import com.axoft.tangopedido.data.remote.utils.HttpRoutes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PaisClient {
    @GET(HttpRoutes.GET_PAIS)
    suspend fun GetPaisById(
        @Query("idGva133") id: Int,
        @Header("ApiAuthorization") token: String = BuildConfig.API_TOKEN,
        @Header("Company") company: Int = BuildConfig.API_COMPANY
    ): Response<PaisResponse>
}
