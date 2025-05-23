package com.axoft.tangopedido.presentation.mapper

import android.graphics.drawable.Drawable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import com.axoft.tangopedido.domain.model.Articulo
import com.axoft.tangopedido.domain.model.Cliente
import com.axoft.tangopedido.presentation.model.SimpleItemCard

fun Articulo.toSimpleItem(): SimpleItemCard {
    return SimpleItemCard(
        codigo = this.codigo,
        descripcion = this.descripcion,
        icon = Icons.Default.Star
    )
}

fun Cliente.toSimpleItem(): SimpleItemCard {
    return SimpleItemCard(
        codigo = this.codigo,
        descripcion = this.razonSocial,
        icon = Icons.Default.Person
    )
}
