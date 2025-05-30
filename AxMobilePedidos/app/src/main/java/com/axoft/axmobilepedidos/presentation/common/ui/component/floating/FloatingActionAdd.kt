package com.axoft.axmobilepedidos.presentation.common.ui.component.floating

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
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation

@Composable
fun FloatingActionAdd(navController: NavHostController, appNavigation: AppNavigation) {
    FloatingActionButton(
        modifier = Modifier.clip(CircleShape),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = Color.White,
        onClick = { navController.navigate(appNavigation.route) }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add"
        )
    }
}
