package com.axoft.tangopedido.presentation.common.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.model.RenglonCard

@Composable
fun RenglonCard(
    renglonCard: RenglonCard,
    onClick: () -> Unit
) {
    var cantidad by remember { mutableFloatStateOf(renglonCard.cantidadPedida) }

    SimpleCard<Int>(1, { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = renglonCard.codigo,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    QuantitySelectorFloat(
                        cantidad = cantidad,
                        onCantidadChanged = { cantidad = it },
                        step = 1f,
                        unidades = "un"
                    )
                }

                Text(
                    text = renglonCard.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$${renglonCard.precio}",
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "$${renglonCard.importe}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun QuantitySelectorFloat(
    cantidad: Float,
    onCantidadChanged: (Float) -> Unit,
    step: Float = 1f,
    min: Float = 0f,
    max: Float = Float.MAX_VALUE,
    unidades: String = "un",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.size(25.dp),
            onClick = {
                val nuevaCantidad = (cantidad - step).coerceAtLeast(min)
                onCantidadChanged(nuevaCantidad)
            },
            enabled = cantidad > min
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Disminuir",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        Text(
            text = "${"%.2f".format(cantidad)} $unidades",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        IconButton(
            modifier = Modifier.size(20.dp),
            onClick = {
                val nuevaCantidad = (cantidad + step).coerceAtMost(max)
                onCantidadChanged(nuevaCantidad)
            },
            enabled = cantidad < max
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Aumentar",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
