package com.axoft.tangopedido.presentation.common.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.axoft.tangopedido.presentation.common.ui.component.control.QuantitySelectorControl
import com.axoft.tangopedido.presentation.model.view.RenglonCard

/**
 * RenglonCard
 *
 * Composable que muestra la tarjeta visual de un renglón de pedido,
 * incluyendo el código, descripción, precio, importe y un selector interactivo
 * para ajustar la cantidad pedida.
 *
 * @param renglonCard Datos del renglón a mostrar.
 * @param onClick Acción a ejecutar cuando se hace clic en la tarjeta.
 */
@Composable
fun RenglonCard(
    renglonCard: RenglonCard,
    onClick: () -> Unit
) {
    SimpleCard<Int>(1, { onClick() }) {
        RenglonCardBody(renglonCard)
    }
}

@Composable
private fun RenglonCardBody(renglonCard: RenglonCard) {
    var cantidad by remember { mutableFloatStateOf(renglonCard.cantidadPedida) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
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
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 4.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
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
