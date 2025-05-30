package com.axoft.axmobilepedidos.presentation.common.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.axoft.axmobilepedidos.presentation.common.ui.component.control.QuantitySelectorControl
import com.axoft.axmobilepedidos.presentation.model.view.RenglonUi

/**
 * RenglonCard
 *
 * Composable que muestra la tarjeta visual de un renglón de pedido,
 * incluyendo el código, descripción, precio, importe y un selector interactivo
 * para ajustar la cantidad pedida.
 *
 * @param renglonUi Datos del renglón a mostrar.
 * @param onClick Acción a ejecutar cuando se hace clic en la tarjeta.
 */
@Composable
fun RenglonCard(
    renglonUi: RenglonUi,
    onClick: () -> Unit
) {
    BaseCard(
        item = renglonUi,
        onClick = { onClick() }
    ) {
        RenglonCardBody(renglonUi)
    }
}

@Composable
private fun RenglonCardBody(renglonCard: RenglonUi) {
    var cantidad by remember { mutableFloatStateOf(renglonCard.cantidadPedida) }

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = renglonCard.codigo,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            QuantitySelectorControl(
                cantidad = cantidad,
                onCantidadChanged = { cantidad = it },
                step = 1f,
                unidades = "un"
            )
        }

        Text(
            text = renglonCard.descripcion,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Precio unit.",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "$${renglonCard.precio}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "Importe",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
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
