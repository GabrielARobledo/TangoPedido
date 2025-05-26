package com.axoft.tangopedido.presentation.feature.main

import androidx.lifecycle.ViewModel
import com.axoft.tangopedido.data.repository.SessionRepository
import com.axoft.tangopedido.presentation.model.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sessionRepository: SessionRepository
) :
    ViewModel() {

    fun isAuthenticated(): Boolean {
        return sessionRepository.getVendedor() != null
    }

    fun authenticate() {
        sessionRepository.setVendedor(ItemCard(1, "Vendedor", "ROBLEDO", "Gabriel Robledo"))
    }

    fun getStartRoute(): String {
        return if (isAuthenticated()) AppNavigation.Home.route else AppNavigation.Login.route
    }
}