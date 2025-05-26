package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.axoft.tangopedido.presentation.common.animation.SlideNavHost

@Composable
fun MainScreen() {
    val mainViewModel: MainViewModel = hiltViewModel()
    val navController = rememberNavController()

    //Mock para tener sesion iniciada.
    //mainViewModel.authenticate()

    SlideNavHost(
        navController = navController,
        startDestination = mainViewModel.getStartRoute()
    ) {
        mainNavGraph(navController)
    }
}
