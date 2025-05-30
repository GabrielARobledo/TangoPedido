package com.axoft.tangopedido.presentation.model.view

import androidx.compose.ui.graphics.vector.ImageVector
import com.axoft.tangopedido.presentation.model.view.contract.SimpleCardDisplayable

data class ItemCard(
    override val id: Int,
    override val codigo: String?,
    override val descripcion: String?,
    override val icon: ImageVector? = null
) : SimpleCardDisplayable {
    fun getCodeDescription(): String {
        return "$codigo - $descripcion"
    }
}
