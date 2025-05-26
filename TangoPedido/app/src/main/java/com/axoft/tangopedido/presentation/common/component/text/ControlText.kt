package com.axoft.tangopedido.presentation.common.component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ControlText(text: String) {
    Text(
        modifier = Modifier.padding(start = 8.dp),
        text = text.uppercase(),
        fontSize = MaterialTheme.typography.bodySmall.fontSize
    )
}
