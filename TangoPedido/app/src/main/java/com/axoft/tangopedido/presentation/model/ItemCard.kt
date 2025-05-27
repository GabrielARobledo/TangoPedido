package com.axoft.tangopedido.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ItemCard(
    val id: Int,
    val label : String? = null,
    val codigo: String?,
    val descripcion: String?,
    val icon: ImageVector? = null,
    val isFavorite: Boolean = false
) {
    fun getCodeDescription(): String {
        return "$codigo - $descripcion"
    }
}
