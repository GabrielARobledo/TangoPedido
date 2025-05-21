package com.axoft.tangopedido.data.remote.api

import com.axoft.tangopedido.data.remote.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/2d3f2927-837d-4d25-91c5-4f1185fd01c5")
    suspend fun doLogin(): Response<LoginResponse>
}
