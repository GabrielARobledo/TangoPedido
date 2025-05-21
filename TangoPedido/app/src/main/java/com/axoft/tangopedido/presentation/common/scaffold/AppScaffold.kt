package com.axoft.tangopedido.presentation.common.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.axoft.tangopedido.presentation.common.toolbar.AppToolbar

@Composable
fun AppScaffold(modifier: Modifier = Modifier, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { AppToolbar() },
        content = content
    )
}
