package com.axoft.tangopedido.presentation.common.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SubtitleText(text: String) {
    Text(
        text = text,
        fontSize = MaterialTheme.typography.titleSmall.fontSize
    )
}
