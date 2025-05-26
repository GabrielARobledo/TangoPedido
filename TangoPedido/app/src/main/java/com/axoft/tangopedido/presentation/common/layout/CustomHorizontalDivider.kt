package com.axoft.tangopedido.presentation.common.layout

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomHorizontalDivider() {
    HorizontalDivider(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        thickness = 1.dp,
        color = Color.LightGray
    )
}
