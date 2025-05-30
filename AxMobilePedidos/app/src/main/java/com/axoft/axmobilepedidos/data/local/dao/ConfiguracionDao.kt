package com.axoft.axmobilepedidos.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.axoft.axmobilepedidos.data.local.entities.SettingEntity

@Dao
interface ConfiguracionDao {
    @Insert
    suspend fun insert(settingEntity: SettingEntity)

    @Query("SELECT * FROM setting WHERE username = :username")
    suspend fun getUserByUsername(username: String): SettingEntity?

    @Query("SELECT * FROM setting")
    suspend fun getUserAll(): List<SettingEntity?>
}
