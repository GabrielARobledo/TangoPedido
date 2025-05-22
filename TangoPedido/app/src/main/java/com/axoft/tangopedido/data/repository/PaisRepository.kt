package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.remote.api.pais.PaisService
import com.axoft.tangopedido.data.remote.dto.PaisResponse
import javax.inject.Inject

class PaisRepository @Inject constructor (private val paisService: PaisService){
    suspend fun getById(id: Int): PaisResponse? {
        return paisService.GetPaisById(id = id)
    }
}
