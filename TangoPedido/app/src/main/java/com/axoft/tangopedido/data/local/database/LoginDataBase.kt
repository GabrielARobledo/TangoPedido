package com.axoft.tangopedido.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.axoft.tangopedido.data.local.dao.ConfiguracionDao
import com.axoft.tangopedido.data.local.entities.SettingEntity

@Database(entities = [SettingEntity::class], version = 1)
abstract class LoginDataBase : RoomDatabase() {
    abstract fun configuracionDao(): ConfiguracionDao
}
