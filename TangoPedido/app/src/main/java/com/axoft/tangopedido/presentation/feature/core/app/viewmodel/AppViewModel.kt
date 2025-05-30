package com.axoft.tangopedido.presentation.feature.core.app.viewmodel

import androidx.lifecycle.ViewModel
import com.axoft.tangopedido.data.repository.app.SessionRepository
import com.axoft.tangopedido.presentation.feature.core.app.navigation.AppNavigation
import com.axoft.tangopedido.presentation.model.view.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * AppViewModel
 *
 * ViewModel principal de la aplicación, encargado de gestionar el estado global
 * de autenticación. Consulta y manipula la sesión actual (vendedor) usando
 * SessionRepository, y determina la ruta inicial de la aplicación.
 *
 * @param sessionRepository Repositorio de sesión que almacena la información del vendedor autenticado.
 */
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
