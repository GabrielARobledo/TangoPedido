package com.axoft.tangopedido.presentation.feature.app.viewmodel

import androidx.lifecycle.ViewModel
import com.axoft.tangopedido.data.repository.app.SessionRepository
import com.axoft.tangopedido.presentation.feature.app.navigation.AppNavigation
import com.axoft.tangopedido.presentation.model.view.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val sessionRepository: SessionRepository
) :
    ViewModel() {

    fun isAuthenticated(): Boolean {
        return sessionRepository.getVendedor() != null
    }

    fun authenticate() {
        sessionRepository.setVendedor(ItemCard(1, "ROBLEDO", "Gabriel Robledo"))
    }

    fun getStartRoute(): String {
        return if (isAuthenticated()) AppNavigation.Home.route else AppNavigation.Login.route
    }
}