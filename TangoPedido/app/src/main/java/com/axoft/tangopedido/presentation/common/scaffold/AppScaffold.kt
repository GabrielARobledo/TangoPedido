package com.axoft.tangopedido.presentation.common.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.toolbar.AppToolbar

@Composable
fun AppScaffold(
    isScrollable: Boolean = false,
    floatingActionButton: @Composable () -> Unit = {},
    topBar: @Composable () -> Unit = { AppToolbar() },
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        floatingActionButton = floatingActionButton
    ) { innerPadding ->
        val baseModifier = Modifier
            .padding(innerPadding)
            .padding(top = 16.dp)

        if (isScrollable) {
            LazyColumn(
                modifier = baseModifier,
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item {
                    content(innerPadding)
                }
            }
        } else {
            Column(modifier = baseModifier) {
                content(innerPadding)
            }
        }
    }
}
