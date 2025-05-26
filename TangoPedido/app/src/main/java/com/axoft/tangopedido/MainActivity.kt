package com.axoft.tangopedido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.axoft.tangopedido.presentation.feature.main.MainScreen
import com.axoft.tangopedido.presentation.theme.TangoPedidoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TangoPedidoTheme {
                MainScreen()
            }
        }
    }
}
