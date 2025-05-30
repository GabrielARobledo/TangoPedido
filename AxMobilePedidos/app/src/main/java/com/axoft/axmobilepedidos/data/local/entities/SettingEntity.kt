package com.axoft.axmobilepedidos.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "setting")
data class SettingEntity(@PrimaryKey(autoGenerate = true) val id: Int, val username: String)