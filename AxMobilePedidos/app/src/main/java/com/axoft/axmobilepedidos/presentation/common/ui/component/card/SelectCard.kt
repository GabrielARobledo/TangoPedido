package com.axoft.axmobilepedidos.presentation.common.ui.component.card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.ControlText
import com.axoft.axmobilepedidos.presentation.common.ui.theme.hint

/**
 * SelectCard
 *
 * Composable que representa una tarjeta seleccionable con una etiqueta y un valor,
 * mostrando un ícono indicativo a la derecha para denotar navegación o acción pendiente.
 * Ideal para representar campos que abren un selector o una nueva pantalla al hacer clic.
 *
 * @param label Texto de la etiqueta que describe el campo.
 * @param value Texto por defecto a mostrar si no hay valor seleccionado.
 * @param valueSelected Valor seleccionado actual (opcional); si es null, se muestra el valor por defecto.
 * @param onClick Acción a ejecutar cuando se hace clic en la tarjeta.
 */
@Composable
fun SelectCard(label: String, value: String, valueSelected: String? = null, onClick: () -> Unit) {
    ControlText(label)
    BaseCard<Int>(1, { onClick() }) {
        SelectCardBody(value, valueSelected)
    }
}

@Composable
private fun SelectCardBody(value: String, valueSelected: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = valueSelected ?: value,
            style = MaterialTheme.typography.labelLarge,
            color = if (valueSelected == null) MaterialTheme.colorScheme.hint else Color.Unspecified,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(30.dp)
        )
    }
}
