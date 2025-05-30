package com.axoft.tangopedido.presentation.common.ui.component.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.ui.component.text.TitleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    navigationIcon: @Composable () -> Unit = {},
    info: @Composable () -> Unit = {},
    subtitle: @Composable () -> Unit = {}
) {
    Column {
        TopAppBar(
            modifier = Modifier.height(80.dp),
            navigationIcon = navigationIcon,
            title = { ToolbarTopSection(info) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        subtitle.invoke()
    }
}

@Composable
fun ToolbarTopSection(info: @Composable () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TitleText("Tango Pedido")
        Spacer(modifier = Modifier.weight(1f))
        info.invoke()
        Spacer(modifier = Modifier.width(5.dp))
    }
}