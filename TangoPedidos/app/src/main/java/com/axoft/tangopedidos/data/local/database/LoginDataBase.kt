package com.axoft.tangopedidos.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.axoft.tangopedidos.data.local.dao.ConfiguracionDao
import com.axoft.tangopedidos.data.local.entities.SettingEntity

@Database(entities = [SettingEntity::class], version = 1)
abstract class LoginDataBase : RoomDatabase() {
    abstract fun configuracionDao(): ConfiguracionDao
}
