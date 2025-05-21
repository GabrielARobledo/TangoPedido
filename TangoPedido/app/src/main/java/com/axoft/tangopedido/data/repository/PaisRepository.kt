package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.remote.api.PaisService
import com.axoft.tangopedido.data.remote.dto.PaisResponse
import javax.inject.Inject

class PaisRepository @Inject constructor (private val paisService: PaisService){
    suspend fun getById(process: Int, id: Int, token: String, company: Int): PaisResponse? {
        return paisService.getById(process = process, id = id, token = token, company = company)
    }
}