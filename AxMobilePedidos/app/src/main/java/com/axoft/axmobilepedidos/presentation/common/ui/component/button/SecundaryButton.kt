package com.axoft.axmobilepedidos.presentation.common.ui.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * SecondaryButton
 *
 * Composable que representa un botón secundario o de menor jerarquía visual,
 * usando el estilo OutlinedButton con los colores primarios del MaterialTheme.
 * Ideal para acciones complementarias o menos destacadas.
 *
 * @param text Texto a mostrar dentro del botón.
 * @param onClick Acción a ejecutar cuando se hace clic en el botón.
 * @param modifier Modificador Compose opcional para personalizar el layout externo.
 * @param enabled Indica si el botón está habilitado (por defecto true).
 */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text)
    }
}
