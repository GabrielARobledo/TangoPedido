package com.axoft.tangopedido

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.axoft.tangopedido.presentation.feature.home.HomeViewModel
import com.axoft.tangopedido.presentation.feature.login.LoginViewModel
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
