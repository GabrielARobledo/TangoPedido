package com.axoft.axmobilepedidos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ArticuloResponse(
    @SerializedName("items") val data: List<ArticuloDto>
)

data class ArticuloDto(
    @SerializedName("id") val id: Int,
    @SerializedName("codigo") val codigo: String?,
    @SerializedName("descripcion") val descripcion: String?,
    @SerializedName("descripcionAdicional") val descripcionAdicional: String?
)
