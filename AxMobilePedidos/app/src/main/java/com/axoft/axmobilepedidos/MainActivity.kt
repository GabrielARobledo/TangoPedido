package com.axoft.axmobilepedidos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.axoft.axmobilepedidos.presentation.common.ui.theme.TangoPedidoTheme
import com.axoft.axmobilepedidos.presentation.feature.app.ui.AppScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TangoPedidoTheme {
                AppScreen()
            }
        }
    }
}
