package com.axoft.tangopedido.presentation.feature.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.axoft.tangopedido.presentation.common.animation.SlideNavHost
import com.axoft.tangopedido.presentation.feature.home.HomeScreen
import com.axoft.tangopedido.presentation.feature.home.HomeViewModel
import com.axoft.tangopedido.presentation.feature.login.LoginScreen
import com.axoft.tangopedido.presentation.feature.login.LoginViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val loginViewModel: LoginViewModel = hiltViewModel()

    SlideNavHost(
        navController = navController,
        startDestination = AppNavigation.Login.route
    ) {
        composable(AppNavigation.Login.route) {
            LoginScreen(loginViewModel, navController)
        }
        composable(AppNavigation.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(homeViewModel)
        }
    }
}
