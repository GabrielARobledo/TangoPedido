package com.axoft.tangopedido.presentation.common.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.toolbar.AppToolbar

@Composable
fun AppScaffold(
    isScrollable: Boolean = false,
    topBar: @Composable () -> Unit = { AppToolbar() },
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        content = { innerPadding ->
            val modifier = Modifier
                .padding(innerPadding)
                .padding(top = 8.dp)
                .then(if (isScrollable) Modifier.verticalScroll(rememberScrollState()) else Modifier)

            Column(modifier = modifier) {
                content.invoke(innerPadding)
            }
        }
    )
}
