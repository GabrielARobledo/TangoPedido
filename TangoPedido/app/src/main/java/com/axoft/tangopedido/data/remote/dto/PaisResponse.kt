package com.axoft.tangopedido.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PaisResponse(
    @SerializedName("value") val value : Value,
    @SerializedName("message") val message: String?,
    @SerializedName("exceptionInfo") val exceptionInfo: String?,
    @SerializedName("succeeded") val succeeded: Boolean
)

data class Value(
    @SerializedName("ID_GVA133") val ID_GVA133: Int,
    @SerializedName("COD_GVA133") val COD_GVA133: String,
    @SerializedName("NOM_PAIS") val NOM_PAIS: String,
    @SerializedName("CUIT_JURID") val CUIT_JURID: String,
    @SerializedName("CUIT_FISIC") val CUIT_FISIC: String,
    @SerializedName("ID_CLASIFICACION_PAIS_AFIP") val ID_CLASIFICACION_PAIS_AFIP: Int,
    @SerializedName("COD_AFIP") val COD_AFIP: Int,
    @SerializedName("OBSERVACIONES") val OBSERVACIONES: String?
)