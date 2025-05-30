package com.axoft.axmobilepedidos.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.axoft.axmobilepedidos.data.local.dao.ConfiguracionDao
import com.axoft.axmobilepedidos.data.local.entities.SettingEntity

@Database(entities = [SettingEntity::class], version = 1)
abstract class LoginDataBase : RoomDatabase() {
    abstract fun configuracionDao(): ConfiguracionDao
}
