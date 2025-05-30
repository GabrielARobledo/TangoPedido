package com.axoft.tangopedido.presentation.common.ui.component.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.ui.component.toolbar.AppToolbar

/**
 * AppScaffold
 *
 * Composable base que define la estructura general de las pantallas de la aplicación,
 * envolviendo el contenido en un Scaffold de Jetpack Compose con soporte para:
 * topBar configurable (por defecto usando AppToolbar),
 * FloatingActionButton opcional,
 * y disposición interna scrollable (LazyColumn) o fija (Column).
 *
 * Este componente centraliza paddings, layout y comportamiento estructural,
 * asegurando consistencia visual y de interacción entre todas las pantallas.
 *
 * @param isScrollable Indica si el contenido debe mostrarse dentro de un LazyColumn (scrollable).
 * @param floatingActionButton Composable opcional para incluir un FAB en la pantalla.
 * @param topBar Composable opcional para definir la barra superior (por defecto AppToolbar).
 * @param content Bloque composable principal que representa el contenido de la pantalla,
 * recibiendo los PaddingValues calculados por el Scaffold.
 */
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
