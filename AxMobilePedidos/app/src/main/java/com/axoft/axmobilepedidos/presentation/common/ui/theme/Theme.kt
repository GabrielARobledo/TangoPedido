package com.axoft.axmobilepedidos.presentation.common.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = DarkColorActivePrimary,         // Azul principal (botones, topbar)
    onPrimary = DarkFontButtonPrimary,        // Texto sobre el azul
    background = DarkColorBackground,         // Fondo general
    surface = DarkColorHeader,                // Superficie (cards, sheets)
    onSurface = DarkFontPrimary,              // Texto sobre superficies
    secondary = DarkColorButtons,             // Colores alternativos (ej. botones neutros)
    onSecondary = DarkFontButtons,            // Texto sobre esos botones
    error = DarkColorDanger,
    onError = DarkFontButtonPrimary,
)

private val LightColorScheme = lightColorScheme(
    primary = LightColorActivePrimary,        // Azul principal (botones, topbar)
    onPrimary = LightFontButtonPrimary,       // Texto blanco sobre azul
    background = LightColorBackground,        // Fondo general
    surface = LightColorHeader,               // Superficies blancas (cards, sheets)
    onSurface = LightFontPrimary,             // Texto en cards/sheets
    secondary = LightColorButtons,            // Botones secundarios
    onSecondary = LightFontButtons,           // Texto en esos botones
    error = LightColorDanger,
    onError = LightFontButtonPrimary
)

@Composable
fun TangoPedidoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // false para usar el color personalizado.
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
