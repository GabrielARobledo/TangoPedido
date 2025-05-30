package com.axoft.axmobilepedidos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VendedorResponse(
    @SerializedName("items") val Items: List<VendedorDto>
)

data class VendedorDto(
    @SerializedName("idGva23") val id: Int,
    @SerializedName("codigo") val codigo: String?,
    @SerializedName("nombre") val nombre: String?
)
