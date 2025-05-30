package com.axoft.axmobilepedidos.presentation.common.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.axoft.axmobilepedidos.presentation.model.view.contract.SimpleCardDisplayable

/**
 * InfoCard
 *
 * Composable genérico que representa una tarjeta informativa reutilizable.
 * Usa un SimpleCard como contenedor estilizado, y muestra los datos principales
 * de cualquier entidad que implemente la interfaz SimpleCardDisplayable.
 *
 * @param item Objeto que implementa SimpleCardDisplayable, contiene la información a mostrar.
 * @param imageIcon Icono opcional que se muestra a la izquierda (por defecto null).
 * @param onClick Acción a ejecutar cuando el usuario hace clic en la tarjeta.
 */
@Composable
fun <T : SimpleCardDisplayable> InfoCard(
    item: T,
    imageIcon: ImageVector? = null,
    onClick: (T) -> Unit
) {
    BaseCard<T>(item = item, onClick = { onClick(item) }) {
        InfoCardBody(item, imageIcon)
    }
}

@Composable
private fun <T : SimpleCardDisplayable> InfoCardBody(item: T, imageIcon: ImageVector?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.codigo.orEmpty(),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = item.descripcion.orEmpty(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        if (imageIcon != null) {
            Icon(
                imageVector = imageIcon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 12.dp)
            )
        }
    }
}
