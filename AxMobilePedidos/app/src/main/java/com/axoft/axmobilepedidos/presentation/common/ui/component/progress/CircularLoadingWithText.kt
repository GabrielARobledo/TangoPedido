package com.axoft.axmobilepedidos.presentation.common.ui.component.progress

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * CircularLoadingWithText
 *
 * Composable que muestra un indicador de progreso circular centrado en pantalla,
 * acompañado de un texto opcional que describe el estado de carga.
 *
 * @param text Texto descriptivo adicional a mostrar debajo del indicador (puede ser null).
 */
@Composable
fun CircularLoadingWithText(text: String? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            if (text != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Cargando $text...")
            }
        }
    }
}
