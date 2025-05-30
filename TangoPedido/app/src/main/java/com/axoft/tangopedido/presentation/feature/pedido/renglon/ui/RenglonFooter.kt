package com.axoft.tangopedido.presentation.feature.pedido.renglon.ui

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.axoft.tangopedido.presentation.feature.core.app.navigation.AppNavigation

/**
 * RenglonFooter
 *
 * Composable que representa un FloatingActionButton (FAB) para la pantalla de renglones.
 * Permite navegar a la pantalla de selección de artículos al hacer clic.
 *
 * @param navController Controlador de navegación usado para realizar la navegación
 * hacia la ruta definida en AppNavigation.
 */
@Composable
fun RenglonFooter(navController: NavHostController) {
    FloatingActionButton(
        modifier = Modifier.clip(CircleShape),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        onClick = { navController.navigate(AppNavigation.Articulo.route) }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }
}
