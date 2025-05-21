package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.axoft.tangopedido.presentation.common.scaffold.AppScaffold
import com.axoft.tangopedido.presentation.feature.home.HomeScreen
import com.axoft.tangopedido.presentation.feature.login.LoginScreen

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val isLogged by mainViewModel.isLogged.collectAsState()

    AppScaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if (isLogged) {
                HomeScreen()
            } else {
                LoginScreen(mainViewModel)
            }
        }
    }
}
