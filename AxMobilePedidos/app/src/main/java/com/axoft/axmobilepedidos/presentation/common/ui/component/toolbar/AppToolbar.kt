package com.axoft.axmobilepedidos.presentation.common.ui.component.toolbar

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
import com.axoft.axmobilepedidos.presentation.common.ui.component.text.TitleText

/**
 * AppToolbar
 *
 * Composable que define la barra superior general reutilizable de la aplicación.
 * Incluye un bloque para el ícono de navegación (por ejemplo, back), un título principal fijo
 * ("Tango Pedido"), un bloque opcional de información adicional, y una sección opcional
 * para subtítulos o elementos colocados debajo de la barra principal.
 *
 * Está diseñado como un contenedor flexible que puede ser adaptado por scaffolds especializados
 * como HomeToolbar o LookupScaffold.
 *
 * @param navigationIcon Composable opcional para mostrar un ícono de navegación (ej. back).
 * @param info Composable opcional para mostrar información adicional a la derecha del título.
 * @param subtitle Composable opcional que se coloca debajo de la barra principal (ej. subtítulos dinámicos).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    navigationIcon: @Composable () -> Unit = {},
    toolbarRightContent: @Composable () -> Unit = {},
    subtitle: @Composable () -> Unit = {}
) {
    Column {
        TopAppBar(
            modifier = Modifier.height(80.dp),
            navigationIcon = navigationIcon,
            title = { TitleContent(toolbarRightContent) },
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
private fun TitleContent(toolbarRightContent: @Composable () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TitleText("Tango Pedidos")
        Spacer(modifier = Modifier.weight(1f))
        toolbarRightContent()
        Spacer(modifier = Modifier.width(5.dp))
    }
}
