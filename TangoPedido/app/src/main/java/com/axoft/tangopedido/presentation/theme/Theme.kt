package com.axoft.tangopedido.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = DarkColorBackground,
    primary = DarkColorActivePrimary,
    onPrimary = DarkFontButtonPrimary,
    secondary = DarkColorButtons,
    onSecondary = DarkFontButtons,
    surface = DarkColorHeader,
    onSurface = DarkFontPrimary,
    error = DarkColorDanger,
    onError = DarkFontButtonPrimary
)

private val LightColorScheme = lightColorScheme(
    background = LightColorBackground,
    primary = LightColorActivePrimary,
    onPrimary = LightFontButtonPrimary,
    secondary = LightColorButtons,
    onSecondary = LightFontButtons,
    surface = LightColorHeader,
    onSurface = LightFontPrimary,
    error = LightColorDanger,
    onError = LightFontButtonPrimary
)

@Composable
fun TangoPedidoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
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
        typography = Typography,
        content = content
    )
}