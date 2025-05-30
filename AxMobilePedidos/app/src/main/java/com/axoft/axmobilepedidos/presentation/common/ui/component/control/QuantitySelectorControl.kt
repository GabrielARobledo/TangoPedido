package com.axoft.axmobilepedidos.presentation.common.ui.component.control

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * QuantitySelectorControl
 *
 * Composable que permite al usuario aumentar o disminuir interactivamente
 * una cantidad flotante dentro de un rango definido, mostrando el valor actualizado
 * y las unidades configuradas.
 *
 * @param cantidad Valor actual de la cantidad.
 * @param onCantidadChanged Callback que recibe la nueva cantidad al cambiar.
 * @param step Incremento/decremento por clic (por defecto 1f).
 * @param min Valor mínimo permitido (por defecto 0f).
 * @param max Valor máximo permitido (por defecto Float.MAX_VALUE).
 * @param unidades Texto que representa las unidades (por defecto "un").
 * @param modifier Modificador Compose opcional para personalizar el layout.
 */
@Composable
fun QuantitySelectorControl(
    cantidad: Float,
    onCantidadChanged: (Float) -> Unit,
    step: Float = 1f,
    min: Float = 0f,
    max: Float = Float.MAX_VALUE,
    unidades: String = "un",
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.size(32.dp),
            onClick = {
                val nuevaCantidad = (cantidad - step).coerceAtLeast(min)
                onCantidadChanged(nuevaCantidad)
            },
            enabled = cantidad > min
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "Disminuir",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Text(
            text = "${"%.2f".format(cantidad)} $unidades",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        IconButton(
            modifier = Modifier.size(32.dp),
            onClick = {
                val nuevaCantidad = (cantidad + step).coerceAtMost(max)
                onCantidadChanged(nuevaCantidad)
            },
            enabled = cantidad < max
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Aumentar",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
