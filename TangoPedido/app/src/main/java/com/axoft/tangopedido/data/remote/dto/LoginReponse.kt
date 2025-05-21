package com.axoft.tangopedido.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("titulo") val titulo: String
)
