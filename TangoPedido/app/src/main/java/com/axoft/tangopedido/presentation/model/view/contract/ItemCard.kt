package com.axoft.tangopedido.presentation.model.view.contract

import androidx.compose.ui.graphics.vector.ImageVector

interface SimpleCardDisplayable {
    val id: Int
    val codigo: String?
    val descripcion: String?
    val icon: ImageVector?
}
