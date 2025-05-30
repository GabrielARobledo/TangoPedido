package com.axoft.axmobilepedidos.presentation.common.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * SubtitleText
 *
 * Composable que muestra un texto estilizado como subtítulo,
 * usando el tamaño de fuente definido por el estilo titleSmall del tema actual.
 * Ideal para mostrar información secundaria, subtítulos o detalles bajo encabezados principales.
 *
 * @param text Texto a mostrar como subtítulo.
 */
@Composable
fun SubtitleText(text: String) {
    Text(
        text = text,
        fontSize = MaterialTheme.typography.titleSmall.fontSize,
        color = MaterialTheme.colorScheme.onPrimary
    )
}
