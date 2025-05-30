package com.axoft.axmobilepedidos.presentation.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.hint: Color
    @Composable
    get() = if (isSystemInDarkTheme()) DarkHintColor else LightHintColor