package com.axoft.axmobilepedidos.presentation.common.ui.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * CustomTextField
 *
 * Composable que representa un campo de texto personalizado, estilizado con borde redondeado,
 * fondo transparente y colores definidos manualmente.
 * Ideal para formularios y entradas de datos donde se busca un diseño consistente y minimalista.
 *
 * @param modifier Modificador Compose opcional para personalizar el layout externo.
 * @param label Texto de etiqueta que describe el campo.
 * @param value Valor actual del texto.
 * @param keyboardOptions Opciones del teclado (por defecto, teclado estándar).
 * @param onValueChange Callback que recibe el nuevo valor cuando el texto cambia.
 */
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .border(1.5.dp, Color(0xFF303D46), RoundedCornerShape(8.dp)),
        singleLine = true,
        value = value,
        label = { Text(text = label) },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Color.Gray,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = keyboardOptions,
        onValueChange = {
            onValueChange(it)
        },
    )
}
