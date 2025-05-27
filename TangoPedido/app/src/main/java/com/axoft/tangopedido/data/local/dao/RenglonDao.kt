package com.axoft.tangopedido.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.axoft.tangopedido.data.local.entities.RenglonEntity

@Dao
interface RenglonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(renglon: RenglonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(renglones: List<RenglonEntity>)

    @Query("SELECT * FROM renglones")
    suspend fun getAll(): List<RenglonEntity>

    @Query("DELETE FROM renglones")
    suspend fun deleteAll()
}