package com.axoft.tangopedido.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.axoft.tangopedido.data.local.dao.ConfiguracionDao
import com.axoft.tangopedido.data.local.dao.RenglonDao
import com.axoft.tangopedido.data.local.entities.RenglonEntity
import com.axoft.tangopedido.data.local.entities.SettingEntity

@Database(
    entities = [SettingEntity::class, RenglonEntity::class],
    version = 2
)
abstract class PedidosDB : RoomDatabase() {
    abstract fun configuracionDao(): ConfiguracionDao
    abstract fun renglonDao(): RenglonDao
}
