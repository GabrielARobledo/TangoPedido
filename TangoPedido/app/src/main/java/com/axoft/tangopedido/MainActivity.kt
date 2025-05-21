package com.axoft.tangopedido

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.axoft.tangopedido.presentation.feature.main.MainScreen
import com.axoft.tangopedido.presentation.feature.main.MainViewModel
import com.axoft.tangopedido.presentation.theme.TangoPedidoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TangoPedidoTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}
