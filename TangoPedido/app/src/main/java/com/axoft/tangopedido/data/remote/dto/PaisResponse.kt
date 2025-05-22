package com.axoft.tangopedido.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PaisResponse(
    @SerializedName("coD_GVA133") val codGva133 : String,
    @SerializedName("noM_PAIS") val nomPais: String?
)
