package com.axoft.tangopedido.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "renglones")
data class RenglonEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val codigo: String,
    val descripcion: String,
    val cantidad: Int,
    val importe: Double
)