package com.axoft.tangopedido.presentation.common.ui.component.card

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.ui.component.text.ControlText
import com.axoft.tangopedido.presentation.common.ui.theme.hint

@Composable
fun SelectCard(
    label: String, value: String, valueSelected: String? = null, onClick: () -> Unit
) {
    ControlText(label)
    SimpleCard<Int>(1, { onClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                text = valueSelected ?: value,
                style = MaterialTheme.typography.labelLarge,
                color = if (valueSelected == null) MaterialTheme.colorScheme.hint else Color.Unspecified,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
