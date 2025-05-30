package com.axoft.axmobilepedidos.presentation.common.ui.component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * ControlText
 *
 * Composable que muestra un texto en mayúsculas, alineado a la izquierda con padding,
 * usando el tamaño de fuente definido por el estilo bodySmall del tema actual.
 * Ideal para rotular campos, etiquetas o pequeños encabezados dentro de formularios o listas.
 *
 * @param text Texto a mostrar en mayúsculas.
 */
@Composable
fun ControlText(text: String) {
    Text(
        modifier = Modifier.padding(start = 8.dp),
        text = text.uppercase(),
        fontSize = MaterialTheme.typography.bodySmall.fontSize
    )
}
