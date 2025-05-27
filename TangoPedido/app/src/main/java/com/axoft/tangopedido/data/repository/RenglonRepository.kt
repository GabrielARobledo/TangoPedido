package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.local.dao.RenglonDao
import com.axoft.tangopedido.data.local.entities.RenglonEntity
import javax.inject.Inject

class RenglonRepository @Inject constructor(
    private val renglonDao: RenglonDao
) {
    suspend fun guardarRenglon(renglon: RenglonEntity) = renglonDao.insert(renglon)

    suspend fun guardarLista(renglones: List<RenglonEntity>) = renglonDao.insertAll(renglones)

    suspend fun obtenerRenglones(): List<RenglonEntity> = renglonDao.getAll()

    suspend fun borrarRenglones() = renglonDao.deleteAll()
}
