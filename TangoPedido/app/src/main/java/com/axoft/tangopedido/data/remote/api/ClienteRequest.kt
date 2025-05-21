package com.axoft.tangopedido.data.remote.api

import com.axoft.tangopedido.data.remote.dto.GetByIdResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ClienteRequest {
    @GET("Api/GetById/")
    suspend fun getById(
        @Query("process") process: Int,
        @Query("id") id: Int,
        @Header("ApiAuthorization") token: String,
        @Header("Company") company: Int
    ): Response<GetByIdResponseDto>
}