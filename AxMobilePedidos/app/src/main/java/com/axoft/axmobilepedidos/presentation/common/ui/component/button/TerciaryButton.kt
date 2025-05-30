package com.axoft.axmobilepedidos.presentation.common.ui.component.button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * TertiaryButton
 *
 * Composable que representa un botón terciario o de mínima jerarquía visual,
 * usando el estilo TextButton con los colores primarios del MaterialTheme.
 * Ideal para acciones secundarias, menos destacadas o enlaces.
 *
 * @param text Texto a mostrar dentro del botón.
 * @param onClick Acción a ejecutar cuando se hace clic en el botón.
 * @param modifier Modificador Compose opcional para personalizar el layout externo.
 * @param enabled Indica si el botón está habilitado (por defecto true).
 */
@Composable
fun TertiaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text)
    }
}
