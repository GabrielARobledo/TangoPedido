package com.axoft.axmobilepedidos.presentation.common.ui.component.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.axmobilepedidos.presentation.common.ui.component.toolbar.AppToolbar

/**
 * AppScaffold
 *
 * Composable base que define la estructura general de las pantallas.
 * - Usa Scaffold con topBar (por defecto AppToolbar) y FloatingActionButton opcional.
 * - Aplica padding interno del Scaffold más 16.dp extra arriba.
 * - Recibe un bloque de contenido (content) que se muestra dentro de un Column.
 *
 * Sirve como contenedor general para mantener consistencia visual en la app.
 */
@Composable
fun AppScaffold(
    floatingActionButton: @Composable () -> Unit = {},
    topBar: @Composable () -> Unit = { AppToolbar() },
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
        floatingActionButton = floatingActionButton
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            content()
        }
    }
}
