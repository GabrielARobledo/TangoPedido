package com.axoft.axmobilepedidos.presentation.common.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

/**
 * TitleText
 *
 * Composable que muestra un texto destacado como título principal,
 * usando el tamaño de fuente definido por el estilo titleLarge del tema actual
 * y con peso en negrita (bold).
 * Ideal para encabezados de secciones, títulos de pantalla o bloques destacados.
 *
 * @param text Texto a mostrar como título.
 */
@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontWeight = FontWeight.Bold,
    )
}