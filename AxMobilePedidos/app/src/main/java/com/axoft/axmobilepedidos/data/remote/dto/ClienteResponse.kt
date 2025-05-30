package com.axoft.axmobilepedidos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ClienteResponse(
    @SerializedName("items") val Items: List<ClienteDto>
)

data class ClienteDto(
    @SerializedName("idGva14") val id: Int,
    @SerializedName("codigo") val codigo: String?,
    @SerializedName("razonSocial") val razonSocial: String?
)
