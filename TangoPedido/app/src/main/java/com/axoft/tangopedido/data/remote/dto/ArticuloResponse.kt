package com.axoft.tangopedido.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ArticuloResponse(
    @SerializedName("data") val data: List<Articulo>,
    @SerializedName("message") val message: String?,
    @SerializedName("maxRowVersion") val maxRowVersion: Int?,
    @SerializedName("succeeded") val succeeded: Boolean
)

data class Articulo(
    @SerializedName("codigO_ARTICULO") val codigo: String,
    @SerializedName("descripcio") val descripcion: String,
    @SerializedName("desC_ADICIONAL") val descripcionAdicional: String
)