package com.axoft.axmobilepedidos.presentation.common.ui.component.button

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * PrimaryButton
 *
 * Composable que representa el botón principal o destacado de la interfaz,
 * estilizado con los colores primarios definidos en el MaterialTheme.
 * Ideal para acciones principales en una pantalla.
 *
 * @param text Texto a mostrar dentro del botón.
 * @param modifier Modificador Compose opcional para personalizar el layout externo.
 * @param enabled Indica si el botón está habilitado (por defecto true).
 * @param onClick Acción a ejecutar cuando se hace clic en el botón.
 */
@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text(text)
    }
}
