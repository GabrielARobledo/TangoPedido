package com.axoft.tangopedido.presentation.feature.app.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.axoft.tangopedido.presentation.common.ui.component.animation.SlideNavHost
import com.axoft.tangopedido.presentation.feature.app.viewmodel.AppViewModel

@Composable
fun AppScreen() {
    val appViewModel: AppViewModel = hiltViewModel()
    val navController = rememberNavController()

    //Mock para tener sesion iniciada.
    //mainViewModel.authenticate()

    SlideNavHost(
        navController = navController,
        startDestination = appViewModel.getStartRoute()
    ) {
        appNavGraph(navController)
    }
}
