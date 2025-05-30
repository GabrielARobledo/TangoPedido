package com.axoft.axmobilepedidos.presentation.common.ui.component.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.SubtitleText

/**
 * HomeToolbar
 *
 * Composable que define la barra superior principal (toolbar) de la aplicación,
 * mostrando opcionalmente un botón de retroceso, un subtítulo con la información del usuario
 * (incluyendo ícono y nombre), y un bloque informativo adicional.
 *
 * Está diseñado para ser usado como topBar dentro de AppScaffold, aportando
 * una estructura consistente y visualmente alineada al tema de la aplicación.
 *
 * @param subtitle Texto opcional que muestra el nombre o información del usuario actual.
 * @param arrowBack Booleano que indica si se debe mostrar el ícono de retroceso.
 * @param backOnClick Acción a ejecutar cuando se hace clic en el ícono de retroceso.
 */
@Composable
fun HomeToolbar(
    subtitle: String?,
    arrowBack: Boolean = false,
    toolbarRightContent: @Composable () -> Unit = {},
    backOnClick: () -> Unit = {}
) {
    AppToolbar(
        navigationIcon = {
            if (arrowBack) {
                BackArrowIcon(backOnClick)
            }
        },
        toolbarRightContent = toolbarRightContent,
        subtitle = { SubtitleContent(subtitle) }
    )
}

@Composable
private fun BackArrowIcon(onClick: () -> Unit) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = "Volver",
        modifier = Modifier.clickable(onClick = onClick)
    )
}

@Composable
private fun SubtitleContent(subtitle: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PersonIcon()
        Spacer(modifier = Modifier.width(8.dp))
        SubtitleText(text = subtitle ?: "")
    }
}

@Composable
private fun PersonIcon() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(Color.White)
            .padding(1.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Cuenta",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}