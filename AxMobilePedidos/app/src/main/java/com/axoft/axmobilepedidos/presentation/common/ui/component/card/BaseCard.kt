package com.axoft.axmobilepedidos.presentation.common.ui.component.card

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * BaseCard
 *
 * Composable genérico que actúa como contenedor estilizado para tarjetas (Cards).
 * Encapsula estilo, forma, colores y manejo de clic, permitiendo reutilizarlo
 * con diferentes tipos de contenido y modelos de datos.
 *
 * @param item Objeto asociado al card, pasado al callback onClick cuando se presiona.
 * @param onClick Acción a ejecutar al hacer clic en el card, recibiendo el objeto item.
 * @param content Contenido composable interno a renderizar dentro del card.
 */
@Composable
fun <T> BaseCard(
    item: T,
    onClick: (T) -> Unit,
    content: @Composable () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = { onClick(item) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        content()
    }
}
